package com.example.demo.controller;

import com.example.demo.Model.Ordonnance;
import com.example.demo.Service.InOrdonnance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Ordonnance")
public class Ordannance_Controler {
    @Autowired
    InOrdonnance ordonnanceService;

    @GetMapping("/liste")
    public List<Ordonnance> affichAll(){
        return ordonnanceService.getAll();
    }

    @PostMapping("/Ajout/{id}")
    public void Ajouter(@PathVariable int id, @RequestBody Ordonnance ordonnance){
        ordonnanceService.save(id, ordonnance);
    }

    @GetMapping("/{id}")
    public List<Ordonnance> afficherOrdBYId(@ PathVariable int id){
        return ordonnanceService.findByIdConsulation(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        ordonnanceService.delete(id);
    }
}
