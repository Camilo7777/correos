package com.vid.envio_correos.services;

import com.vid.envio_correos.models.Invoice;
import com.vid.envio_correos.repositories.InvoiceRepository;
import com.vid.envio_correos.repositories.JefeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.sql.Date;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        // Definir el rango de fechas
        LocalDate now = LocalDate.now();
        LocalDate endOfWeek = now.plusDays(30);

        // Obtener todas las facturas en el rango de fechas
        List<Invoice> dueInvoices = invoiceRepository.findAll();

        LocalDate today = LocalDate.now().plusDays(10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String todayStr = today.format(formatter);

        System.out.println("Fecha actual: " + LocalDate.now()); // Imprimir fecha actual
        System.out.println("Fecha para consulta: " + todayStr); // Imprimir fecha formateada


        LocalDate today2 = LocalDate.now();
        Date sqlDate = Date.valueOf(today);


        List<Invoice> dueInvoices0 = invoiceRepository.findByDueDate(sqlDate);
        List<Invoice> dueInvoices2 = invoiceRepository.findByDueDateAfterOrEqualNative(todayStr);
        List<Invoice> dueInvoices3 = invoiceRepository.findByDueDateAfterOrEqualFixed();

        if (!dueInvoices.isEmpty()) {
            for (Invoice invoice : dueInvoices) {
                String codJefe = invoice.getCodJefe();
                String nameJefe = jefeRepository.findByCodJefe(codJefe).getName();
                String emailJefe = jefeRepository.findByCodJefe(codJefe).getEmail();
                String nameEmpleado = invoice.getName() + " " + invoice.getLastName();
                java.util.Date date = invoice.getDueDate();

                String subject = "Notificación de contratos por vencer";
                String text = "Señor " + nameJefe + ", el contrato de: " + nameEmpleado + " vence el " + date;

                sendEmail(emailJefe, subject, text);
            }
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
