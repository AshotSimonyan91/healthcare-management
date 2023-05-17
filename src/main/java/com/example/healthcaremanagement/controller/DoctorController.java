package com.example.healthcaremanagement.controller;

import com.example.healthcaremanagement.entity.Doctor;
import com.example.healthcaremanagement.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ashot Simonyan on 11.05.23.
 */

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Value("${healthcare.upload.image.path}")
    private String imageUploadPath;


    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public String doctorsPage(ModelMap modelMap) {
        List<Doctor> all = doctorRepository.findAll();
        modelMap.addAttribute("doctors", all);
        return "doctors";
    }

    @GetMapping("remove")
    public String removeDoctor(@RequestParam("id") int id) {
        String profilePic = doctorRepository.getReferenceById(id).getProfilePic();
        File file = new File(imageUploadPath + profilePic);
        if (file.exists()) {
            file.delete();
        }
        doctorRepository.deleteById(id);
        return "redirect:/doctors";
    }

    @GetMapping("add")
    public String addDoctorPage(ModelMap modelMap) {
        modelMap.addAttribute("doctor", new Doctor());
        return "createDoctor";
    }

    @PostMapping("add")
    public String addDoctor(@Valid @ModelAttribute Doctor doctor, Errors errors, @RequestParam("profile_pic") MultipartFile multipartFile) throws IOException {
        if (errors.hasErrors()) {
            return "createDoctor";
        }
        if (multipartFile != null && !multipartFile.isEmpty()) {
            String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
            File file = new File(imageUploadPath + fileName);
            multipartFile.transferTo(file);
            doctor.setProfilePic(fileName);
        }
        doctorRepository.save(doctor);
        return "redirect:/doctors";
    }

}
