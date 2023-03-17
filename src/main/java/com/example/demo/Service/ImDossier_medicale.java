package com.example.demo.Service;

import com.example.demo.Model.Dossier_medicale;
import com.example.demo.Repository.Dossier_medicale_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImDossier_medicale implements InDossier_medicale{

    @Autowired
    Dossier_medicale_repository dossierMedicaleRepository;

    @Override
    public List<Dossier_medicale> findAll() {
        return dossierMedicaleRepository.findAll();
    }

    @Override
    public Optional<Dossier_medicale> findById(int id) {
        return dossierMedicaleRepository.findById(id);
    }

    @Override
    public void save(Dossier_medicale dossierMedicale) {
        Dossier_medicale d = new Dossier_medicale();
        d.setId(dossierMedicale.getId());
        dossierMedicaleRepository.save(d);
    }
}
