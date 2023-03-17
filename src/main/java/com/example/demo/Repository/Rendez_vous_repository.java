package com.example.demo.Repository;

import com.example.demo.Model.Patient;
import com.example.demo.Model.Rendez_Vous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface Rendez_vous_repository extends JpaRepository<Rendez_Vous, Integer> {
@Query("SELECT p FROM Patient p , Rendez_Vous r WHERE p.num_patient=r.patient.num_patient")
    List<Patient> findPatientWithRDV();
}
