package br.com.skills.admin.resources;

import br.com.skills.admin.entities.SkillEntity;
import br.com.skills.admin.repositories.SkillsRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillsResource {

    @Autowired
    private SkillsRepository skillsRepository;

    @PostMapping
    @ApiOperation(value = "Creates a skill")
    public ResponseEntity<SkillEntity> newSkill(@RequestParam @Valid String description, HttpServletRequest request) {
        SkillEntity skill = new SkillEntity();
        skill.setDescription(description);
        skillsRepository.save(skill);

        String location = request.getRequestURL().toString() + "/" + skill.getId().toString();

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
