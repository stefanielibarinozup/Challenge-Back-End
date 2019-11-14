package br.com.zup.challenge.apiRest.controller;

import br.com.zup.challenge.apiRest.domain.People;
import br.com.zup.challenge.apiRest.repository.PeopleRepository;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import br.com.zup.challenge.apiRest.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class PeopleController {

    @Autowired
    private Service service;

    public PeopleController(Service service) {
        this.service = service;
    }

    @PostMapping("/people")
    public People salvaPeople(@RequestBody @Valid People people){
        return service.salvaPeople(people);
    }
    @GetMapping("/people")
    public List<People> listarPeople(){
        return service.listarPeople();
    }

    @PutMapping("/people")
    public People atualizaPeople(@RequestBody @Valid People people)
    {
        return service.atualizaPeople(people);
    }

    @DeleteMapping("/people/{id}")
    public void deletePeople(@RequestBody @Valid People people)
    {
        service.deletePeople(people);
    }

}
