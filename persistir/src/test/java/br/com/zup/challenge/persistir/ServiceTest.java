package br.com.zup.challenge.persistir;

import br.com.zup.challenge.persistir.controller.PeopleController;
import br.com.zup.challenge.persistir.domain.People;
import br.com.zup.challenge.persistir.repository.PeopleRepository;
import br.com.zup.challenge.persistir.service.Service;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;


@WebMvcTest(PeopleController.class)
public class ServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Rule
    public ErrorCollector error = new ErrorCollector();

    private Service service;
    private PeopleRepository peopleRepository;
    private People people;
    private List<People> listPeople;

    public ServiceTest(){}

    @Before
    public void setUp(){
        this.service = new Service();
        peopleRepository = Mockito.mock(PeopleRepository.class);
        service.setPeopleRepository(peopleRepository);

        people = new People(id);

        people.setId(16);
        people.setNome("Joao Carlos");
        people.setCpf("22233345678");
    }

    @Test
    public void testSavePeople(){
        when(peopleRepository.save(people)).thenReturn(people);
        Assert.assertEquals(people, service.savePeople(people));
    }
    @Test
    public void testListPeople() {
        when(peopleRepository.findAll()).thenReturn(listPeople);
        Assert.assertEquals(listPeople, service.listPeople());
    }
    @Test
     public void testUpdatePeople(){
        when(peopleRepository.save(people)).thenReturn(people);
        Assert.assertEquals(people, service.updatePeople(people));
    }

}
