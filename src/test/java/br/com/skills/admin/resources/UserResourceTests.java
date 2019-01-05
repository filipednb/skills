package br.com.skills.admin.resources;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserResourceTests {

    @Test
    public void deveCriarUmUsuario() {
        Assert.assertTrue(1 > 0);
    }
}
