package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Dossier_medicale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "dossierMedicale", fetch = FetchType.LAZY)
    private Collection<Consultaion> consultaions;
}
