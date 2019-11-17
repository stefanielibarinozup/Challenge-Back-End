package br.com.zup.challenge.apiRestH2.repository;

import br.com.zup.challenge.apiRestH2.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
    People findById(long id);
}
