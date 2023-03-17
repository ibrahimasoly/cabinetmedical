package com.example.demo.Repository;

import com.example.demo.Model.Dossier_medicale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dossier_medicale_repository extends JpaRepository<Dossier_medicale, Integer> {
}
