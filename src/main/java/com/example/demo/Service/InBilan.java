package com.example.demo.Service;

import com.example.demo.Model.Bilan;
import com.example.demo.Model.Consultaion;
import com.example.demo.Model.Ordonnance;
import com.example.demo.Model.Patient;

import java.util.List;
import java.util.Optional;

public interface InBilan {
    public List<Bilan> findAll();
    public Optional<Bilan> fingById(int id);
    public void  save(int id,Bilan bilan);
    public void deleted(int id);
    public List<Bilan> findByIdConsulation(int id);
}
