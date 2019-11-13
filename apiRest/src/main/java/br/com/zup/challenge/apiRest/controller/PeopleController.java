package br.com.zup.challenge.apiRest.controller;

import br.com.zup.challenge.apiRest.domain.People;
import br.com.zup.challenge.apiRest.repository.PeopleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping()
public class PeopleController {

    @Autowired
    private PeopleRepository repository;

    public PeopleController(PeopleRepository peopleRepository) {
        this.repository = peopleRepository;
    }

    @PostMapping("/people")
    public People salvaPeople(@RequestBody @Valid People people){
        System.out.println(people.getCpf().toString()+ people.getNome().toString());
        return repository.save(people);
    }

    @GetMapping("/people")
    public List<People> listarPeople(){
        return repository.findAll();
    }

    @ApiOperation(value="Atualiza")
    @PutMapping("/people")
    public People atualizaPeople(@RequestBody @Valid People people){
        return repository.save(people);
    }
    @ApiOperation(value="Deleta pessoa")
    @DeleteMapping("/people/{cpf}")
    public void deletePeople(@RequestBody @Valid People people){
        repository.delete(people);
    }

}
