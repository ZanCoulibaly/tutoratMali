package com.example.apitutorat.classe.services;

import com.example.apitutorat.classe.Classe;

import java.util.List;

public interface ClasseService {

    public Classe addClasse(Long id, Classe classe);
    public List<Classe> classeByTuteur(Long id);
    public Classe classeById(Long id);
    public Classe updateClasse( Classe classe,Long id);
}
