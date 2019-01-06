package br.com.skills.admin.resources;

import br.com.skills.admin.entities.UserEntity;
import br.com.skills.admin.repositories.UsersRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersResource {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping
    @ApiOperation(value = "Creates a user", response = UserEntity.class)
    public UserEntity createUser(@RequestParam @Valid String name) {
        UserEntity user = new UserEntity();
        user.setName(name);
        usersRepository.save(user);
        return  user;
    }

    @GetMapping
    @ApiOperation(value = "Get all users", response = UserEntity.class)
    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) usersRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find user by id", response = UserEntity.class)
    UserEntity findOne(@PathVariable Long id) {
        return usersRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found"));
    }



}
