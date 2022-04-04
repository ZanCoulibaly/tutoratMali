package com.example.apitutorat.classe.repository;

import com.example.apitutorat.classe.Classe;
import com.example.apitutorat.classe.ClasseEtat;
import com.example.apitutorat.users.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe, Long> {

    public List<Classe> findByTuteurAndEtat(Utilisateur tuteur, ClasseEtat etat);
}
