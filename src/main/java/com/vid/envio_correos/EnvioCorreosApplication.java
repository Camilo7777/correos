package com.vid.envio_correos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EnvioCorreosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvioCorreosApplication.class, args);
	}

}
