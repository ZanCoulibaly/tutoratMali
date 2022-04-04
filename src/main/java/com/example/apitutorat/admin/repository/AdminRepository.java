package com.example.apitutorat.admin.repository;

import com.example.apitutorat.admin.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrateur, Long> {
    public Administrateur findByLoginAndPassword(String login, String password);
}
