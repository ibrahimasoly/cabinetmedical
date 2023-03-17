package com.example.demo.Service;

import com.example.demo.Model.Patient;
import com.example.demo.Model.Rendez_Vous;
import com.example.demo.Repository.Patient_repository;
import com.example.demo.Repository.Rendez_vous_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@ControllerAdvice
@Service
public class ImPatient implements InPatient_service{

    @Autowired
    Patient_repository patient_repository;
    Rendez_vous_repository rendezVousRepository;

    @Override
    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        patients=patient_repository.findAll(Sort.by("nom").ascending()  );
        return patients;
    }

    @Override
    public Optional<Patient> findById(int id) {
        return patient_repository.findById(id);

    }

    @Override
    public void save(Patient patient) {
        Patient p = new Patient();
        p.setNom(patient.getNom());
        p.setPrenom(patient.getPrenom());
        p.setDate_naissance(patient.getDate_naissance());
        p.setSexe(patient.getSexe());
        p.setTelephone(patient.getTelephone());
        patient_repository.save(p);
    }

    @Override
    public void delete(int id) {
       Optional<Patient> p = patient_repository.findById(id);
       p.ifPresent(patient_repository::delete);

    }

    @Override
    public void update(int id, Patient patient) {
       Patient p = patient_repository.findById(id).orElse(null);
       p.setNom(patient.getNom());
       p.setPrenom(patient.getPrenom());
       p.setDate_naissance(patient.getDate_naissance());
       p.setSexe(patient.getSexe());
       p.setTelephone(p.getTelephone());
       patient_repository.save(p);
    }

    @Override
    public List<Patient> search(String nom) {
        return patient_repository.searchPatient(nom);
    }
}
