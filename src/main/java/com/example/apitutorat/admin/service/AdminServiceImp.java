package com.example.apitutorat.admin.service;

import com.example.apitutorat.admin.Administrateur;
import com.example.apitutorat.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService{

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Administrateur addAdmin(Administrateur administrateur) {
        return adminRepository.save(administrateur);
    }

    @Override
    public Administrateur Connextion(String login, String password) {
        return adminRepository.findByLoginAndPassword(login, password);
    }
}
