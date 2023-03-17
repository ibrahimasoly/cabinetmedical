package com.example.demo.controller;

import com.example.demo.Model.Dossier_medicale;
import com.example.demo.Service.InDossier_medicale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Dossier_medicale")
@CrossOrigin(origins = "http://localhost:4200")
public class Dossier_medicale_Controler {
    @Autowired
    InDossier_medicale dossierMedicale_service;

    @GetMapping()
    public List<Dossier_medicale> afficherAll(){
        System.out.println("bonjour");
        return dossierMedicale_service.findAll();
    }

    @GetMapping("/{id}")
    public Dossier_medicale afficherById(@PathVariable int id){
        return dossierMedicale_service.findById(id).orElse(null);
    }

    @PostMapping()
    public void save(@RequestBody Dossier_medicale dossierMedicale){
        dossierMedicale_service.save(dossierMedicale);
    }
}
