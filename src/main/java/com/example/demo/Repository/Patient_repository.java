package com.example.demo.Repository;

import com.example.demo.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Patient_repository extends JpaRepository<Patient, Integer> {
    @Query("SELECT p FROM Patient p WHERE p.nom LIKE:nom")
    List<Patient> searchPatient(@Param(value = "nom") String nom);
}
