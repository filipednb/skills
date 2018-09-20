package br.com.skills.admin.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @RequestMapping("/login")
    public String doLogin() {
         return  new String("logado");
    }



}
