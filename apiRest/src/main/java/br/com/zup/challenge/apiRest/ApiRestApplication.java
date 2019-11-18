package br.com.zup.challenge.apiRest;

import br.com.zup.challenge.apiRest.repository.PeopleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
	//	"br.com.zup.challenge.apiRest.repository"})
public class ApiRestApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(ApiRestApplication.class, args);
	}

}
