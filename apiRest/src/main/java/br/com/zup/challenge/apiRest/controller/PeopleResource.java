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
@RequestMapping(value="/api")
@Api(value="ApiRest peopleS")
public class PeopleResource {

    @Autowired
    PeopleRepository peopleRepository;


    @ApiOperation(value="Cadastrar pessoa")
    @PostMapping("/people")
    public People salvaPeople(@RequestBody @Valid People people){
        return peopleRepository.save(people);
    }

    @GetMapping("/people")
    public List<People> listarPeople(){
        return peopleRepository.findAll();
    }

    @ApiOperation(value="Atualiza")
    @PutMapping("/people")
    public People atualizaPeople(@RequestBody @Valid People people){
        return peopleRepository.save(people);
    }
    @ApiOperation(value="Deleta pessoa")
    @DeleteMapping("/people")
    public void deletePeople(@RequestBody @Valid People people){
        peopleRepository.delete(people);
    }

}
