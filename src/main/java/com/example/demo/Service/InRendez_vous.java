package com.example.demo.Service;

import com.example.demo.Model.Patient;
import com.example.demo.Model.Rendez_Vous;

import java.util.List;
import java.util.Optional;

public interface InRendez_vous {
    public List<Rendez_Vous> getAll();
    public Optional<Rendez_Vous> findById(int id);
    public void save(int id,Rendez_Vous rendez_vous);
    public void delete(int id);
    public void update(int id, Rendez_Vous rendez_vous);
    public List<Patient> findPatientWithRDV();
}
