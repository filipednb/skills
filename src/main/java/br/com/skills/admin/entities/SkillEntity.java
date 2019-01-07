package br.com.skills.admin.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class SkillEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private UserEntity user;

}
