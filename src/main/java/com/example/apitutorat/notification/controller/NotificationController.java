package com.example.apitutorat.notification.controller;

import com.example.apitutorat.notification.Notification;
import com.example.apitutorat.notification.services.NotificationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/notification/")
public class NotificationController {

    @Autowired
    NotificationServiceImp notificationServiceImp;

    @GetMapping("liste/{id}")
    public List<Notification> ListNotification(@PathVariable Long id){
        return notificationServiceImp.GetByReceveur(id);
    }
}
