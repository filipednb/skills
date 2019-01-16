package br.com.skills.admin.resources;

import br.com.skills.admin.entities.SkillEntity;
import br.com.skills.admin.repositories.SkillsRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SkillsResourceTest {

    @Autowired
    SkillsRepository skillsRepository;



    @Test
    public void deveCriarUmaHabilidade() {

        SkillEntity skill = new SkillEntity();

        skill.setDescription("Bom no futebol");

        skillsRepository.save(skill);

        Assertions.assertThat(skill).isExactlyInstanceOf(SkillEntity.class);
        Assertions.assertThat(skill.getId()).isPositive();

    }

}
