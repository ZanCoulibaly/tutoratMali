package com.example.apitutorat.matiere.service;


import com.example.apitutorat.matiere.Matiere;
import com.example.apitutorat.matiere.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereServiceImp implements MatiereService {

    @Autowired
    MatiereRepository matiereRepository;

    @Override
    public Matiere addMaiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public List<Matiere> listMatiere() {
        return matiereRepository.findAll();
    }
}
