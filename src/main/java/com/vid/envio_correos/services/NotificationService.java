package com.vid.envio_correos.services;

import com.vid.envio_correos.models.Invoice;
import com.vid.envio_correos.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private JavaMailSender mailSender;

    private static final String[] NOTIFY_EMAILS = {"camilo_escobar1993@hotmail.com", "camilo04241993@gmail.com"};

    //@Scheduled(cron = "0 0 9 * * MON") // Ejecutar cada lunes a las 9 AM
    @Scheduled(cron = "0 */2 * * * *")
    public void notifyDueInvoices() {
        LocalDate now = LocalDate.now();
        LocalDate endOfWeek = now.plusDays(7);

        List<Invoice> dueInvoices = invoiceRepository.findByDueDateBetween(now, endOfWeek);
        if (!dueInvoices.isEmpty()) {
            String invoiceDetails = dueInvoices.stream()
                    .map(invoice -> "Factura #" + invoice.getInvoiceNumber() + " - Vence el: " + invoice.getDueDate())
                    .collect(Collectors.joining("\n"));

            String subject = "Notificación de facturas por vencer";
            String text = "Las siguientes facturas están por vencer esta semana:\n\n" + invoiceDetails;

            sendEmail(NOTIFY_EMAILS, subject, text);
        }
    }

    private void sendEmail(String[] to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
