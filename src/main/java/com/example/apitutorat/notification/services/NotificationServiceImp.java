package com.example.apitutorat.notification.services;

import com.example.apitutorat.notification.Notification;
import com.example.apitutorat.notification.repository.NotificationRepository;
import com.example.apitutorat.users.Utilisateur;
import com.example.apitutorat.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImp implements NotiticationService{

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<Notification> GetByReceveur(Long id) {
        Utilisateur receveur = usersRepository.findById(id).get();
        return notificationRepository.findByReceveur(receveur);
    }
}
