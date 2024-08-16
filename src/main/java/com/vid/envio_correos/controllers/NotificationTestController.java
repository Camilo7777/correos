package com.vid.envio_correos.controllers;

import com.vid.envio_correos.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class NotificationTestController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notify")
    public String triggerNotification() {
        notificationService.notifyDueInvoices();
        return "Notification triggered!";
    }

    @PutMapping("/update")
    public String createBoss() {
        notificationService.notifyDueInvoices();
        return "Notification triggered!";
    }
}
