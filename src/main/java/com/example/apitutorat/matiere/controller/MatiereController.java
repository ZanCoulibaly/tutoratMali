package com.example.apitutorat.matiere.controller;

import com.example.apitutorat.matiere.Matiere;
import com.example.apitutorat.matiere.service.MatiereServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/matiere/")
public class MatiereController {

    @Autowired
    MatiereServiceImp matiereServiceImp;

    @PostMapping("add")
    public Matiere addMatiere(Matiere matiere){
        return matiereServiceImp.addMaiere(matiere);
    }

    @GetMapping("list")
    public List<Matiere> listMatiere(){
        return matiereServiceImp.listMatiere();
    }

}
