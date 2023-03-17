package com.example.demo.Service;

import com.example.demo.Model.Ordonnance;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InOrdonnance {
    public List<Ordonnance> getAll();
    public Optional<Ordonnance> findById(int id);
    public void save(int id,Ordonnance patient);
    public void delete(int id);
    public void update(int id, Ordonnance patient);
    public List<Ordonnance> findByIdConsulation(int id);
}
