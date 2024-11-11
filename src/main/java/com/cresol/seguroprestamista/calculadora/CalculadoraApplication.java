package com.cresol.seguroprestamista.calculadora;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class CalculadoraApplication {
	public static void main(String[] args) {
		SpringApplication.run(CalculadoraApplication.class, args);
	}

}
