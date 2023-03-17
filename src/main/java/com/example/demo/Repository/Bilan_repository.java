package com.example.demo.Repository;

import com.example.demo.Model.Bilan;
import com.example.demo.Model.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Bilan_repository extends JpaRepository<Bilan, Integer> {
    @Query("SELECT b FROM Bilan b WHERE b.consultaion.num_consul=:id")
    public List<Bilan> findByIdConsulation(@Param("id") int id);
}
