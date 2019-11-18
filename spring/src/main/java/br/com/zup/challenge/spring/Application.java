package br.com.zup.challenge.spring;

import br.com.zup.challenge.spring.crud.CreateData;
import br.com.zup.challenge.spring.crud.DeleteData;
import br.com.zup.challenge.spring.crud.ListData;
import br.com.zup.challenge.spring.crud.ReadData;
import br.com.zup.challenge.spring.service.ServiceSpring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.security.Provider;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
		ServiceSpring.operacoesComandos(args);
	}




}
