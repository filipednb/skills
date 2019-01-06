package br.com.skills.admin.resources;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersResourceTests extends RestAssured {

    @Test
    public void deveCriarUmUsuario() {
        Assert.assertTrue(1 > 0);
    }
}
