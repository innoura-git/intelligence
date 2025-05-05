package com.innoura.Intelligence.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProjectInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String projectName;
    private String services;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public ProjectInformation(int id, String projectName, String services) {
        this.id = id;
        this.projectName = projectName;
        this.services = services;
    }
    public ProjectInformation()
    {

    }

    @Override
    public String toString() {
        return "ProjectInformation{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", services='" + services + '\'' +
                '}';
    }
}
