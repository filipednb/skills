package br.com.skills.admin.repositories;

import br.com.skills.admin.entities.SkillEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface SkillsRepository extends CrudRepository<SkillEntity, Long> {

}
