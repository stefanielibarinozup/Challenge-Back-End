package br.com.zup.challenge.integracao;

import br.com.zup.challenge.integracao.model.Data;
import br.com.zup.challenge.integracao.model.DataDelete;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ClientInterface", url = "http://httpbin.org/")
public interface ClientInterface {
    @PostMapping(value = "/post")
    String postData(Data data);

    @DeleteMapping(value = "/delete")
    ResponseEntity<Void> deleteData(@RequestHeader() DataDelete dataDelete);

    @GetMapping(value = "/bearer")
    ResponseEntity<Void> auth(@RequestHeader("Authorization") String authHeader);
}
