package com.example.demo.Repository;

import com.example.demo.Model.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Ordonnance_repository extends JpaRepository<Ordonnance, Integer> {
    @Query("SELECT o FROM Ordonnance o WHERE o.consultaion.num_consul=:id")
    public List<Ordonnance> findByIdConsulation(@Param("id") int id);
}
