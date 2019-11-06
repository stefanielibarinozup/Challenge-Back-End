package br.com.zup.challenge.integracao;

import br.com.zup.challenge.integracao.model.Data;
import br.com.zup.challenge.integracao.model.DataDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@EnableFeignClients
public class IntegracaoHttpApplication implements ApplicationRunner {

	@Autowired
	private ClientInterface clientInterface;

	public static void main(String[] args) {

		SpringApplication.run(IntegracaoHttpApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args)throws Exception {
		String id = "1234";
		String field = "teste";

		postData(id, field);
		deleteData(id);
		auth("Bearer 123456");
	}
	private void postData(String id, String field) {
		String result = clientInterface.postData(new Data(id, field ));
		System.out.println(result);
	}
	private void deleteData(String id){
		ResponseEntity<Void> response;
		response = clientInterface.deleteData(new DataDelete(id));
		if(response.getStatusCodeValue() == 200) {
			System.out.println("Delete OK");
		} else {
			System.out.println("Delete Fail");
		}
	}
	private void auth(String authHeader) {
		ResponseEntity<Void> response;
		response = clientInterface.auth(authHeader);
		if(response.getStatusCodeValue() == 200) {
			System.out.println("Autentication OK");
		} else {
			System.out.println("Autentication Fail");
		}
	}
}
