package com.vid.envio_correos.controllers;

import com.vid.envio_correos.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
