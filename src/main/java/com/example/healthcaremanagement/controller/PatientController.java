package com.example.healthcaremanagement.controller;

import com.example.healthcaremanagement.entity.Patient;
import com.example.healthcaremanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Ashot Simonyan on 11.05.23.
 */

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public String patientsPage(ModelMap modelMap) {
        List<Patient> all = patientRepository.findAll();
        modelMap.addAttribute("patients", all);
        return "patients";
    }

    @GetMapping("remove")
    public String removePatient(@RequestParam("id") int id) {
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }

    @GetMapping("add")
    public String addPatientPage() {
        return "createPatient";
    }

    @PostMapping("add")
    public String addPatient(@ModelAttribute Patient patient, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        patient.setDateOfBirthday(date);
        patientRepository.save(patient);
        return "redirect:/patients";
    }
}
