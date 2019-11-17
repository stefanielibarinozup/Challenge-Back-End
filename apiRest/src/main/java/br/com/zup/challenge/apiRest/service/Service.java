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
    public Service() {}

    public People savePeople(People people){
        return repository.save(people);
    }

    public List<People> listPeople(){
        return repository.findAll();
    }

    public People updatePeople( People people)
    {
        return repository.save(people);
    }

    public void deleteById(long id)
    {
        repository.deleteById(id);
    }

    public void setPeopleRepository(PeopleRepository peopleRepository) {
        this.repository = peopleRepository;
    }

    public void setPeople(People people) {
    }

    public long returnCountRepository() {
        return repository.count();
    }

}
