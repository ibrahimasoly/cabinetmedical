package com.example.demo.Service;

import com.example.demo.Model.Dossier_medicale;

import java.util.List;
import java.util.Optional;

public interface InDossier_medicale {
    public List<Dossier_medicale> findAll();
    public Optional<Dossier_medicale> findById(int id);
    public void save(Dossier_medicale dossierMedicale);
}
