package br.com.skills.admin.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class SkillEntity {

    @Id
    @GeneratedValue
    private Long skillId;

    private String description;

}
