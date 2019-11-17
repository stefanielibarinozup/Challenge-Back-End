package br.com.zup.challenge.apiRest;

import br.com.zup.challenge.apiRest.domain.People;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class PeopleTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();
    private People people;

    public PeopleTest() {
    }

    @Before
    public void setUp() {
        people = new People();
        people.setId(5);
        people.setNome("Joao Carlos");
        people.setCpf("22233345678");
    }

    @Test
    public void testCreate() {
        Assert.assertEquals("22233345678", people.getCpf());
    }
    @Test
    public void testList(){
        Assert.assertEquals(5, people.getId());
    }
    @Test
    public void testUpdate(){
        Assert.assertEquals("Joao Carlos", people.getNome());
    }

}
