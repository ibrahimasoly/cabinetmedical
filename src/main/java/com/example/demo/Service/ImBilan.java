package com.example.demo.Service;

import com.example.demo.Model.Bilan;
import com.example.demo.Model.Consultaion;
import com.example.demo.Model.Ordonnance;
import com.example.demo.Repository.Bilan_repository;
import com.example.demo.Repository.Consultation_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImBilan implements InBilan{

    @Autowired
    Bilan_repository bilanRepository;
    @Autowired
    Consultation_repository consultationRepository;

    @Override
    public List<Bilan> findAll() {
        return bilanRepository.findAll();
    }

    @Override
    public Optional<Bilan> fingById(int id) {
        return bilanRepository.findById(id);
    }

    @Override
    public void save(int id, Bilan bilan) {
        Bilan b = new Bilan();
        b.setId(bilan.getId());
        b.setNomBilan(bilan.getNomBilan());
        Consultaion c = consultationRepository.findById(id).orElse(null);
        b.setConsultaion(c);
        bilanRepository.save(b);


    }

    @Override
    public void deleted(int id) {

    }

    @Override
    public List<Bilan> findByIdConsulation(int id) {
        return bilanRepository.findByIdConsulation(id);
    }
}
