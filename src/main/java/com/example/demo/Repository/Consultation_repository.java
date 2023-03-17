package com.example.demo.Repository;

import com.example.demo.Model.Consultaion;
import com.example.demo.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Consultation_repository extends JpaRepository<Consultaion, Integer> {
    @Query("SELECT DISTINCT p FROM Patient p JOIN p.rendez_vous r JOIN r.consultaion c")
    List<Patient> findPatientByConsultation();
}
