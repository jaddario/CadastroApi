package br.com.addario.cadastroapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = {"br.com.addario.cadastroapi.*"})
public class CadastroApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CadastroApiApplication.class, args);
	}
}
