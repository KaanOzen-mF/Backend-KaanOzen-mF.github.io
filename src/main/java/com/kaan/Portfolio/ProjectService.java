package com.kaan.Portfolio;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public List<ProjectModel> getAllProjects(){
        return projectRepo.findAll();
    }

    public Optional<ProjectModel> getProjectById(Integer id){
        return projectRepo.findById(id);
    }

    public ProjectModel addProject(ProjectModel projectModel){
        return projectRepo.save(projectModel);
    }

    public ProjectModel updateProject(Integer id, ProjectModel updateProject){
        Optional<ProjectModel> optionalProject = projectRepo.findById(id);
        if(optionalProject.isPresent()){
            ProjectModel project = optionalProject.get();
            project.setProjectName(updateProject.getProjectName());
            project.setProjectDesc(updateProject.getProjectDesc());
            project.setProjectUrl(updateProject.getProjectUrl());
            project.setGithub(updateProject.getGithub());
            return projectRepo.save(project);
        }
        return null;
    }

    public void deleteProject(Integer id){
        projectRepo.deleteById(id);
    }
}
