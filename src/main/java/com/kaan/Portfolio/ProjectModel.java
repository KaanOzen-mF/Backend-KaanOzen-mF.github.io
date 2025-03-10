package com.kaan.Portfolio;


import jakarta.persistence.*;

@Entity
@Table(name = "project_model")
public class ProjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String projectName;
    @Column(columnDefinition = "TEXT")
    private String projectDesc;
    private String projectUrl;
    private String github;

    public ProjectModel(String github, String projectUrl, String projectDesc, String projectName) {
        this.github = github;
        this.projectUrl = projectUrl;
        this.projectDesc = projectDesc;
        this.projectName = projectName;
    }

    public ProjectModel(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}