package com.vid.envio_correos.repositories;

import com.vid.envio_correos.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query(value = "SELECT * FROM INVOICE WHERE TRUNC(DUE_DATE) >= TO_DATE(:today, 'DD/MM/YY')", nativeQuery = true)
    List<Invoice> findByDueDateAfterOrEqualNative(@Param("today") String today);

    @Query(value = "SELECT * FROM INVOICE WHERE TRUNC(DUE_DATE) >= TO_DATE('15/09/24', 'DD/MM/YY')", nativeQuery = true)
    List<Invoice> findByDueDateAfterOrEqualFixed();

    @Query("SELECT i FROM Invoice i WHERE i.dueDate = :dueDate")
    List<Invoice> findByDueDate(@Param("dueDate") Date dueDate);

}