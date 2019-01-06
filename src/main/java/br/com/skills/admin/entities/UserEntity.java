package br.com.skills.admin.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue
    private Long userId;

    private String name;

    private String email;

    private String password;

}
