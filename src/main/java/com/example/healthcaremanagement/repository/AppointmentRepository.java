package com.example.healthcaremanagement.repository;

import com.example.healthcaremanagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ashot Simonyan on 11.05.23.
 */

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
