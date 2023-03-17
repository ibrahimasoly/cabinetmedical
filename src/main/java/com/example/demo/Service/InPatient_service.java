package com.example.demo.Service;

import com.example.demo.Model.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface InPatient_service {
    public List<Patient> getAll();
    public Optional<Patient> findById(int id);
    public void save(Patient patient);
    public void delete(int id);
    public void update(int id, Patient patient);
    public List<Patient> search(String nom);

}
