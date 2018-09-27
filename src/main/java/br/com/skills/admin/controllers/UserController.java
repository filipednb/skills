package br.com.skills.admin.controllers;

import br.com.skills.admin.entities.UserEntity;
import br.com.skills.admin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/login")
    public String doLogin() {
        System.out.println(userRepository.findAll().toString());
        return "loga";
    }



}
