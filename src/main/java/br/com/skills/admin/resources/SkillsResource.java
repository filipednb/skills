package br.com.skills.admin.resources;

import br.com.skills.admin.entities.SkillEntity;
import br.com.skills.admin.entities.UserEntity;
import br.com.skills.admin.repositories.SkillsRepository;
import br.com.skills.admin.repositories.UsersRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillsResource {

    @Autowired
    private SkillsRepository skillsRepository;

    @PostMapping
    @ApiOperation(value = "Creates a skill")
    public ResponseEntity<SkillEntity> createSkill(@RequestParam @Valid String description, HttpServletRequest request) {
        SkillEntity skill = new SkillEntity();
        skill.setDescription(description);
        skillsRepository.save(skill);

        String location = request.getRequestURL().toString() + "/" + skill.getSkillId().toString();

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location:", location)
                .body(null);
    }

    @GetMapping
    @ApiOperation(value = "Get all skills", response = SkillEntity.class)
    public List<SkillEntity> getAllUsers() {
        return (List<SkillEntity>) skillsRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find skill by id", response = SkillEntity.class)
    private SkillEntity findUser(@PathVariable Long id) {
        return skillsRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Skill Not Found"));
    }



}
