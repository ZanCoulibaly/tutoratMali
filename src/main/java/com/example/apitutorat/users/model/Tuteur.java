package com.example.apitutorat.users.model;

import com.example.apitutorat.matiere.Matiere;
import com.example.apitutorat.users.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("TUTEUR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tuteur extends Utilisateur {
    private String specialite;
    private String etablissement;
    private boolean disponibilite;
    private int anciennete;
    private String niveau;

    @OneToMany
    private List<Matiere> matieres;
}
