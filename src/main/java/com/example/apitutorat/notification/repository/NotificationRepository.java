package com.example.apitutorat.notification.repository;

import com.example.apitutorat.notification.Notification;
import com.example.apitutorat.users.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    public List<Notification> findByReceveur(Utilisateur receveur);
}
