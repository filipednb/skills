package br.com.skills.admin.repositories;

import br.com.skills.admin.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByUserName(String userEntity);

}
