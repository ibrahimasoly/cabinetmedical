package com.example.demo.Service;

import com.example.demo.Model.Consultaion;
import com.example.demo.Model.Dossier_medicale;
import com.example.demo.Model.Patient;
import com.example.demo.Model.Rendez_Vous;
import com.example.demo.Repository.Consultation_repository;
import com.example.demo.Repository.Dossier_medicale_repository;
import com.example.demo.Repository.Patient_repository;
import com.example.demo.Repository.Rendez_vous_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;
import java.util.Optional;

@Service
@ControllerAdvice
public class Imconsultation implements Inconsulation{


    @Autowired
    Consultation_repository consultation_repository;
    @Autowired
    Patient_repository patient_repository;
    @Autowired
    Rendez_vous_repository rendezVousRepository;
    @Autowired
    Dossier_medicale_repository dossierMedicaleRepository;


    @Override
    public List<Consultaion> findAll() {
        return consultation_repository.findAll();
    }

    @Override
    public List<Patient> AfficherPatientConsul() {
       return consultation_repository.findPatientByConsultation();
    }

    @Override
    public Optional<Consultaion> fingById(int id) {
        return consultation_repository.findById(id);
    }

    @Override
    public void save(int id1,int id,Consultaion consultaion) {
     Consultaion c = new Consultaion();
     c.setNum_consul(consultaion.getNum_consul());
     c.setMotif(consultaion.getMotif());
     c.setAntecedent(consultaion.getAntecedent());
     c.setRapport(consultaion.getRapport());
     Rendez_Vous r = rendezVousRepository.findById(id).orElse(null);
     Dossier_medicale d = dossierMedicaleRepository.findById(id1).orElse(null);
     c.setRendez_vous(r);
     c.setDossierMedicale(d);
     consultation_repository.save(c);
    }

    @Override
    public void deleted(int id) {
        Optional<Consultaion> c = consultation_repository.findById(id);
        c.ifPresent(consultation_repository::delete);
    }
}
