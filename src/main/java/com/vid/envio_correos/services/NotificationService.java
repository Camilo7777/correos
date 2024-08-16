package com.vid.envio_correos.services;

import com.vid.envio_correos.models.Invoice;
import com.vid.envio_correos.repositories.InvoiceRepository;
import com.vid.envio_correos.repositories.JefeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private JefeRepository jefeRepository;
    @Autowired
    private JavaMailSender mailSender;

    //@Scheduled(cron = "0 0 9 * * MON") // Ejecutar cada lunes a las 9 AM
    //@Scheduled(cron = "0 */2 * * * *")
    public void notifyDueInvoices() {
        LocalDate now = LocalDate.now();
        LocalDate endOfWeek = now.plusDays(30);

        List<Invoice> dueInvoices = invoiceRepository.findByDueDateBetween(now, endOfWeek);

        String emailJefe = "";

        String nameJefe = "";

        String nameEmpleado = "";

        LocalDate date = null;

        if (!dueInvoices.isEmpty()) {
            for (int i = 0; i < dueInvoices.size(); i++) {

                 nameJefe = jefeRepository
                        .findByCodJefe(dueInvoices.get(i).getCodJefe()).getName();
                 emailJefe = jefeRepository
                        .findByCodJefe(dueInvoices.get(i).getCodJefe()).getEmail();

                 nameEmpleado =  dueInvoices.get(i).getName() + " " +  dueInvoices.get(i).getLastName();

                 date = dueInvoices.get(i).getDueDate();

                String subject = "Notificación de contratos por vencer";

                String text = "Señor " + nameJefe + " El contrato de : " + nameEmpleado + " Vence el " + date ;


                sendEmail(emailJefe, subject, text);
            }

      ;
        }
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
