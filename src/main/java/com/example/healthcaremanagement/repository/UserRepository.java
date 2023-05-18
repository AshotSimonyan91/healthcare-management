package com.example.healthcaremanagement.repository;

import com.example.healthcaremanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Ashot Simonyan on 11.05.23.
 */

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
