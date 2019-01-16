package br.com.skills.admin.resources;

import br.com.skills.admin.entities.UserEntity;
import br.com.skills.admin.repositories.UsersRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsersResourceTests {

    @Autowired
    UsersRepository usersRepository;

    @Test
    public void shouldCreateUserAndPersist() {

        UserEntity sebastiao = new UserEntity();
        sebastiao.setName("Sebastião");

        usersRepository.save(sebastiao);

        UserEntity sebastiaoPersistido = usersRepository.findById(sebastiao.getId()).orElseThrow();

        Assertions.assertThat(sebastiaoPersistido.getId()).isNotNull();
        Assertions.assertThat(sebastiaoPersistido.getName()).isEqualTo("Sebastião");
        Assertions.assertThat(sebastiaoPersistido.getName()).isNotEqualTo("Juvêncio");

    }
}
