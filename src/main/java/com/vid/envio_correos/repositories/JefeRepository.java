package com.vid.envio_correos.repositories;

import com.vid.envio_correos.models.Jefe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface JefeRepository extends JpaRepository<Jefe, Long> {

    Jefe findByCodJefe(String codJefe);
}
