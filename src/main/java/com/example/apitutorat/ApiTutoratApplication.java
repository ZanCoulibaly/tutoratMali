package com.example.apitutorat;

import com.example.apitutorat.admin.Administrateur;
import com.example.apitutorat.admin.service.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTutoratApplication implements CommandLineRunner {
    @Autowired
    AdminServiceImp adminServiceImp;

    public static void main(String[] args) {
        SpringApplication.run(ApiTutoratApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Administrateur administrateur = new Administrateur(null, "Coulibaly", "Zan", "balamine129", "azerty");
        adminServiceImp.addAdmin(administrateur);
    }
}
