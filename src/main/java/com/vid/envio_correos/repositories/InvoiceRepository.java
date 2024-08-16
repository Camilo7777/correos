package com.vid.envio_correos.repositories;

import com.vid.envio_correos.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByDueDateBetween(LocalDate startDate, LocalDate endDate);
}