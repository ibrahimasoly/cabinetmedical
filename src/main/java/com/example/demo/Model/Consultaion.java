package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Consultaion implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int num_consul;
    private String motif;
    private String antecedent;
    private String rapport;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Rendez_Vous rendez_vous;
    @OneToMany(mappedBy = "consultaion", fetch = FetchType.LAZY)
    private Collection<Ordonnance> ordonnances;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Dossier_medicale dossierMedicale;
    @OneToMany(mappedBy = "consultaion", fetch = FetchType.LAZY)
    private Collection<Bilan> bilans;

}
