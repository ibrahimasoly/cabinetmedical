package com.example.demo.controller;

import com.example.demo.Model.Bilan;
import com.example.demo.Service.InBilan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Bilan")
@CrossOrigin(origins = "http://localhost:4200")
public class Bilan_Controler {

    @Autowired
    InBilan bilanService;

    @GetMapping("")
    public List<Bilan> afficherAll(){
        return bilanService.findAll();
    }

    @GetMapping("/{id}")
    public List<Bilan> afficherBilanByIdConsultation(@PathVariable int id){
        return bilanService.findByIdConsulation(id);
    }

    @PostMapping("/{id}")
    public void ajouter(@PathVariable int id, @RequestBody Bilan bilan){
        bilanService.save(id, bilan);
    }
}
