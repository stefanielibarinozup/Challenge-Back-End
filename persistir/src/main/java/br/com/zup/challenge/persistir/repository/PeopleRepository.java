package br.com.zup.challenge.persistir.repository;

import br.com.zup.challenge.persistir.domain.People;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends CrudRepository<People, Long>, ToInsert<People>{
  People findById(long id);
}
