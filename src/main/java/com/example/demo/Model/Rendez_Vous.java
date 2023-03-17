package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Rendez_Vous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num_RDV;
    @Temporal(TemporalType.DATE)
    private Date date_RDV;
    private Time heure;
    private String description;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @OneToOne(mappedBy = "rendez_vous")
    private Consultaion consultaion;
}
