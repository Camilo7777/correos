package com.vid.envio_correos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "INVOICE")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DUE_DATE")
    private Date dueDate;

    @Column(name = "DOCUMENT_TYPE")
    private String documentType;

    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "LAST_NAME2")
    private String lastName2;

    @Column(name = "COD_JEFE")
    private String codJefe;

}
