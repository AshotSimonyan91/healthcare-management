package com.example.healthcaremanagement.controller;

import com.example.healthcaremanagement.entity.Appointment;
import com.example.healthcaremanagement.entity.Doctor;
import com.example.healthcaremanagement.entity.Patient;
import com.example.healthcaremanagement.repository.AppointmentRepository;
import com.example.healthcaremanagement.repository.DoctorRepository;
import com.example.healthcaremanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Ashot Simonyan on 11.05.23.
 */

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public String appointmentsPage(ModelMap modelMap) {
        List<Appointment> all = appointmentRepository.findAll();
        modelMap.addAttribute("appointments", all);
        return "appointments";
    }

    @GetMapping("remove")
    public String removeAppointment(@RequestParam("id") int id) {
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }

    @GetMapping("add")
    public String addAppointmentPage(ModelMap modelMap) {
        List<Doctor> doctors = doctorRepository.findAll();
        List<Patient> patients = patientRepository.findAll();
        modelMap.addAttribute("doctors", doctors);
        modelMap.addAttribute("patients", patients);
        return "createAppointment";
    }

    @PostMapping("add")
    public String addAppointment(@ModelAttribute Appointment appointment, @RequestParam("date") String date) throws ParseException {
        String dateTime = "01-01-0001 00:00:00";
        if (date != "") {
           dateTime = date.replace("T", " ").concat(":00");
        }
        appointment.setDateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime));
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }
}
