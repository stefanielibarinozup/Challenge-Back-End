package br.com.zup.challenge.persistir.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Wither;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__(@PersistenceConstructor))
public class People{

    private final @Id @Wither Long id;
    private String nome, cpf;

public People(String nome, String cpf, Long id){
    this.id = null;
    this.nome = nome;
    this.cpf = cpf;
}


}
