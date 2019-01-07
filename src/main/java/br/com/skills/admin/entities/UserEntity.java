package br.com.skills.admin.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String password;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SkillEntity> skill = new ArrayList<>();

}
