package br.com.skills.admin.resources;

import br.com.skills.admin.entities.UserEntity;
import br.com.skills.admin.repositories.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/usuario")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @ApiOperation(value = "Creates a user", response = UserEntity.class)
    public UserEntity createUser(@RequestParam @Valid String userName) {

        UserEntity user = new UserEntity();
        user.setUserName(userName);

        userRepository.save(user);

        return  user;


    }

    @PostMapping("/login")
    @ApiOperation(value = "Login into user account")
    public String doLogin(@RequestParam("userName") String usuario, @RequestParam("password") String password) {

        return  "ok";

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find user by id", response = UserEntity.class)
    UserEntity findOne(@PathVariable Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found, id=" + id.toString()));

    }



}
