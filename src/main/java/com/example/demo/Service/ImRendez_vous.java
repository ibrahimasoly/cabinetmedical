package com.example.demo.Service;

import com.example.demo.Model.Consultaion;
import com.example.demo.Model.Patient;
import com.example.demo.Model.Rendez_Vous;
import com.example.demo.Repository.Consultation_repository;
import com.example.demo.Repository.Patient_repository;
import com.example.demo.Repository.Rendez_vous_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;
import java.util.Optional;

@Service
@ControllerAdvice
public class ImRendez_vous implements InRendez_vous{
    @Autowired
    Rendez_vous_repository rendezVousRepository;
    @Autowired
    Patient_repository patient_repository;
    @Autowired
    Consultation_repository consultation_repository;
    @Override
    public List<Rendez_Vous> getAll() {
        return rendezVousRepository.findAll();
    }

    @Override
    public Optional<Rendez_Vous> findById(int id) {

        return rendezVousRepository.findById(id);
    }

    @Override
    public void save(int id,Rendez_Vous rendez_vous) {
        Rendez_Vous rdv = new Rendez_Vous();
        rdv.setNum_RDV(rendez_vous.getNum_RDV());
        rdv.setDate_RDV(rendez_vous.getDate_RDV());
        rdv.setHeure(rendez_vous.getHeure());
        rdv.setDescription(rendez_vous.getDescription());
        Patient p = patient_repository.findById(id).orElse(null);
        rdv.setPatient(p);
        rendezVousRepository.save(rdv);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Rendez_Vous rendez_vous) {

    }

    @Override
    public List<Patient> findPatientWithRDV() {
        return rendezVousRepository.findPatientWithRDV();
    }
}
