package br.com.zup.challenge.apiRest;

import br.com.zup.challenge.apiRest.repository.PeopleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages={
		"br.com.zup.challenge.apiRest.repository"})
public class ApiRestApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(ApiRestApplication.class, args);
	}

}
