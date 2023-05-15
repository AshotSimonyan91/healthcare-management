package com.example.healthcaremanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * Created by Ashot Simonyan on 11.05.23.
 */

@Data
@Entity
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "surname is required")
    private String surname;
    @Email(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "email is no valid")
    private String email;
    @NotBlank(message = "specialty is required")
    private String specialty;
    @Digits(integer = 9,fraction = 0,message = "Enter valid phone number")
    private int phoneNumber;

    private String profilePic;

}
