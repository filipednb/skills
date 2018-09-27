package br.com.skills.admin.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long user_id;

    private String user_name;
}
