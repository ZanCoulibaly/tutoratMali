package com.example.apitutorat.demande;

import com.example.apitutorat.chat.Chat;
import com.example.apitutorat.users.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;
    private LocalDate date;
    private LocalDate acceptDate;
    private LocalTime acceptHeure;
    private String matiere;
    private Etat etat;
    private boolean initier;
    @ManyToOne
    private Utilisateur envoyeur;

    @ManyToOne
    private Utilisateur receveur;

}
