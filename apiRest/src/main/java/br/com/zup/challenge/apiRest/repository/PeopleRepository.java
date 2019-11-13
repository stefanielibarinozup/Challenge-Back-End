package br.com.zup.challenge.apiRest.repository;

import br.com.zup.challenge.apiRest.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
    People findById(long id);


}
