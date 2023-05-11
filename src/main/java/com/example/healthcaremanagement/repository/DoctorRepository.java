package com.example.healthcaremanagement.repository;

import com.example.healthcaremanagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ashot Simonyan on 11.05.23.
 */

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
