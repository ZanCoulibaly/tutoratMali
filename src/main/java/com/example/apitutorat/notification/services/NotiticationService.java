package com.example.apitutorat.notification.services;

import com.example.apitutorat.notification.Notification;

import java.util.List;

public interface NotiticationService {
    public List<Notification> GetByReceveur(Long id);
}
