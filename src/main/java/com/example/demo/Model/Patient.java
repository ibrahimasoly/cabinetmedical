package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num_patient;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private char sexe;
    private String telephone;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection<Rendez_Vous> rendez_vous;

}
