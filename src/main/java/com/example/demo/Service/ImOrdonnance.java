package com.example.demo.Service;

import com.example.demo.Model.Consultaion;
import com.example.demo.Model.Ordonnance;
import com.example.demo.Repository.Consultation_repository;
import com.example.demo.Repository.Ordonnance_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImOrdonnance implements InOrdonnance{

    @Autowired
    Ordonnance_repository ordonnance_repository;
    @Autowired
    Consultation_repository consultation_repository;

    @Override
    public List<Ordonnance> getAll() {
        return ordonnance_repository.findAll();
    }

    @Override
    public Optional<Ordonnance> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(int id, Ordonnance patient) {
        Ordonnance o = new Ordonnance();
        o.setMedicament(patient.getMedicament());
        o.setDurejourprise(patient.getDurejourprise());
        o.setDose(patient.getDose());
        Consultaion c =consultation_repository.findById(id).orElse(null);
        o.setConsultaion(c);
        ordonnance_repository.save(o);
    }

    @Override
    public void delete(int id) {
        Optional<Ordonnance> o = ordonnance_repository.findById(id);
        o.ifPresent(ordonnance_repository::delete);

    }

    @Override
    public void update(int id, Ordonnance patient) {

    }

    @Override
    public List<Ordonnance> findByIdConsulation(int id) {
        return ordonnance_repository.findByIdConsulation(id);
    }
}
