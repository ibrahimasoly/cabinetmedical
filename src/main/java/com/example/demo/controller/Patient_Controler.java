package com.example.demo.controller;

import com.example.demo.Model.Patient;
import com.example.demo.Service.InPatient_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Patient_Controler {
    @Autowired
    InPatient_service patientService;

    @GetMapping("/Patients")
    public List<Patient> Afficher(){
        return patientService.getAll();
    }

    @GetMapping("/Patients/{id}")
    public Optional<Patient> Afficher_patient(@PathVariable int id){
        return patientService.findById(id);
    }

    @GetMapping("/Patients/Recherche")
    public List<Patient> Rechercher(@RequestParam(name = "nom", defaultValue = "") String nom){
        return patientService.search("%"+nom+"%");
    }

    @PostMapping("/Patients")
    public void Ajouter(@RequestBody Patient patient){
        patientService.save(patient);
    }

    @DeleteMapping("/Patients/{id}")
    public void Supprimer(@PathVariable int id){
        patientService.delete(id);
    }

    @PutMapping("/Patients/{id}")
    public  void modifier(@PathVariable int id, @RequestBody Patient patient){
        patientService.update(id, patient);
    }
}
