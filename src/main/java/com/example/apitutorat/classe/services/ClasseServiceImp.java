package com.example.apitutorat.classe.services;
import com.example.apitutorat.classe.Classe;
import com.example.apitutorat.classe.ClasseEtat;
import com.example.apitutorat.classe.repository.ClasseRepository;
import com.example.apitutorat.users.Utilisateur;
import com.example.apitutorat.users.model.Tuteur;
import com.example.apitutorat.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ClasseServiceImp implements ClasseService{

    @Autowired
    ClasseRepository classeRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Classe addClasse(Long id, Classe classe) {
        Utilisateur tuteur = usersRepository.findById(id).get();
        classe.setTuteur(tuteur);
        classe.setCreateDate(LocalDate.now());
        classe.setEtat(ClasseEtat.ACTIVER);
        return classeRepository.save(classe);
    }

    @Override
    public List<Classe> classeByTuteur(Long id) {
        Utilisateur utilisateur = usersRepository.findById(id).get();
        return classeRepository.findByTuteurAndEtat(utilisateur, ClasseEtat.ACTIVER);
    }

    @Override
    public Classe classeById(Long id) {
        return classeRepository.findById(id).get();
    }

    @Override
    public Classe updateClasse(Classe classe, Long id) {
        Classe existClasse = classeRepository.findById(id).get();
        existClasse.setEleves(classe.getEleves());
        classeRepository.save(existClasse);
        return null;
    }
}
