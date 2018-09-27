package br.com.skills.admin.repositories;

import br.com.skills.admin.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
