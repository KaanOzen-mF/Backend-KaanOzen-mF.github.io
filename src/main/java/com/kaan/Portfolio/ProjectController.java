package com.kaan.Portfolio;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping()
    public ResponseEntity<List<ProjectModel>> getAllProjects(){
        List<ProjectModel> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectModel> getProjectById(@PathVariable Integer id){
        Optional<ProjectModel> projectById = projectService.getProjectById(id);
        return projectById.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<ProjectModel> addProject(@RequestBody ProjectModel project){
        ProjectModel savedProject = projectService.addProject(project);
        return ResponseEntity.ok(savedProject);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectModel> updateProject(@PathVariable Integer id, @RequestBody ProjectModel project){
        ProjectModel updatedProject = projectService.updateProject(id, project);
        if (updatedProject != null) {
            return ResponseEntity.ok(updatedProject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer id){
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

}
