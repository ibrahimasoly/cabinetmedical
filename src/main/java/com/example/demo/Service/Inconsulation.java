package com.example.demo.Service;

import com.example.demo.Model.Consultaion;
import com.example.demo.Model.Patient;

import java.util.List;
import java.util.Optional;

public interface Inconsulation {
    public List<Consultaion> findAll();
    public List<Patient> AfficherPatientConsul();
    public Optional<Consultaion> fingById(int id);
    public void  save(int id1, int id,Consultaion consultaion);
    public void deleted(int id);
}
