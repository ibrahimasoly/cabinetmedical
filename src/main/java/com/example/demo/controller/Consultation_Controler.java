package com.example.demo.controller;

import com.example.demo.Model.Consultaion;
import com.example.demo.Model.Patient;
import com.example.demo.Service.Inconsulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Consultation")
public class Consultation_Controler {

    @Autowired
    Inconsulation consultation_service;

    @GetMapping()
    public List<Consultaion> afficherAll(){
        return consultation_service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Consultaion> afficherConsultation(@PathVariable int id){
        return consultation_service.fingById(id);
    }

    @GetMapping("/listePatients")

    public List<Patient> afficherPatient(){
        return consultation_service.AfficherPatientConsul();
    }

    @PostMapping("/{id1}/{id}")
    public void  ajouter(@RequestBody Consultaion consultaion,@PathVariable int id1,  @PathVariable int id){
        consultation_service.save(id1,id,consultaion);
    }

    @DeleteMapping("/{id}")
    public  void supprimer(@PathVariable int id){
        consultation_service.deleted(id);
    }
}
