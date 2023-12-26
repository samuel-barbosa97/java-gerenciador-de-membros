package com.barbosa.Gerenciador.de.membros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class GerenciadorDeMembrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDeMembrosApplication.class, args);
		System.out.println("Projeto rodando");
	}

}
