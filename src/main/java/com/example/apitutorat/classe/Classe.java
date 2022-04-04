package com.example.apitutorat.classe;

import com.example.apitutorat.users.Utilisateur;
import com.example.apitutorat.users.model.Eleve;
import com.example.apitutorat.users.model.Tuteur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String heure;
    private String nom;
    private LocalDate createDate;
    private String matiere;
    private ClasseEtat etat;

    @OneToOne
    private Utilisateur tuteur;

    @OneToMany
    private List<Utilisateur> eleves;
}
