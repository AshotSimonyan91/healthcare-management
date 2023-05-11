package com.example.healthcaremanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private String name;
    private String surname;
    private String email;
    private String specialty;
    private int phoneNumber;
    private String profilePic;
}
