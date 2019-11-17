package br.com.zup.challenge.apiRest;

import br.com.zup.challenge.apiRest.controller.PeopleController;
import br.com.zup.challenge.apiRest.domain.People;
import br.com.zup.challenge.apiRest.repository.PeopleRepository;
import br.com.zup.challenge.apiRest.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PeopleController.class)
public class PeopleControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PeopleController peopleController;
    private People people;

    @MockBean
    private Service service;

    private PeopleRepository repository;

    public PeopleControllerTest(){}

    @Before
    public void setUp(){
        this.peopleController = new PeopleController();
        this.service = new Service();
        repository = Mockito.mock(PeopleRepository.class);
        peopleController.setPeopleRepository(repository);
        service.setPeopleRepository(repository);
        peopleController.setService(service);

        people = new People();
        people.setId(5);
        people.setNome("Joao Carlos");
        people.setCpf("22233345678");
    }

    @Test
    public void testeSavePeople() throws Exception {
        when(repository.save(people)).thenReturn(people);
        Assert.assertEquals(people, peopleController.savePeople(people));
        this.mockMvc.perform(
                post("/api/v1/people")
                        .content(new ObjectMapper().writeValueAsString(people))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testListPeople() throws Exception {
        List<People> listPeople = new ArrayList<People>();
        given(repository.findAll()).willReturn(listPeople);
        Assert.assertEquals(listPeople, peopleController.listPeople());

        this.mockMvc.perform(
                get("/api/v1/people")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdatePeople() throws Exception {
        when(repository.save(people)).thenReturn(people);
        this.mockMvc.perform(
                put("/api/v1/people/{cpf}", "22233345678")
                        .content(new ObjectMapper().writeValueAsString(people))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletePeople() throws Exception{
        this.mockMvc.perform(delete("/api/v1/people/{id}", 16)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testSavePeopleCompareData() {
        when(repository.save(people)).thenReturn(people);
        Assert.assertEquals(people, peopleController.savePeople(people));
        Assert.assertEquals(5, peopleController.savePeople(people).getId());
    }

    @Test
    public void testListPeopleCompareList() {
        List<People> listPeople = new ArrayList<People>();
        when(repository.findAll()).thenReturn(listPeople);
        Assert.assertEquals(listPeople, peopleController.listPeople());
    }
}