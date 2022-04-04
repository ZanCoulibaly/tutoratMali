package com.example.apitutorat.admin.service;

import com.example.apitutorat.admin.Administrateur;

public interface AdminService {
    public Administrateur addAdmin(Administrateur administrateur);
    public Administrateur Connextion(String login , String password);
}
