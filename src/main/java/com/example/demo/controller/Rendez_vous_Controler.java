package com.example.demo.controller;

import com.example.demo.Model.Patient;
import com.example.demo.Model.Rendez_Vous;
import com.example.demo.Service.ImRendez_vous;
import com.example.demo.Service.InRendez_vous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Rendez_vous")
@RestController
public class Rendez_vous_Controler {
    @Autowired
    InRendez_vous rendez_vous_service;

    @GetMapping()
    public List<Rendez_Vous> AfficherAll(){
       return rendez_vous_service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Rendez_Vous> afficherUnPatient( @PathVariable int id){
        return rendez_vous_service.findById(id);
    }

    @GetMapping("/listePatientAvecRDV")
    public List<Patient> afficherPatientRDV(){
        return rendez_vous_service.findPatientWithRDV();
    }

    @PostMapping("/{id}")
    public void Ajouter(@PathVariable int id, @RequestBody Rendez_Vous rendez_vous){
        rendez_vous_service.save(id,rendez_vous);
    }
}
