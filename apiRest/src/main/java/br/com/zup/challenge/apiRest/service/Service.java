package br.com.zup.challenge.apiRest.service;

import br.com.zup.challenge.apiRest.domain.People;
import br.com.zup.challenge.apiRest.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private PeopleRepository repository;

    public Service(PeopleRepository peopleRepository) {

        this.repository = peopleRepository;

    }
    public People salvaPeople(People people){
        return repository.save(people);
    }
    public List<People> listarPeople(){
        return repository.findAll();
    }

    public People atualizaPeople( People people)
    {
        return repository.save(people);
    }

    public void deletePeople(People people)
    {
        repository.delete(people);
    }
}
