package com.innoura.Intelligence.Service;

import com.innoura.Intelligence.Entity.ProjectInformation;
import com.innoura.Intelligence.Repository.ProjectInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class IntelligenceService
{

    @Autowired
    private ProjectInformationRepository projectInformationRepository;

    public String checkProjectService(String projectName) {
        return projectInformationRepository.findByProjectName(projectName);
    }
    public ResponseEntity<String> createNewProject(ProjectInformation projectInformation)
    {
        try {
            projectInformationRepository.save(projectInformation);
            return new ResponseEntity<>("Project created successfully!", HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(
                    "Duplicate project name. Please use a unique project name.",
                    HttpStatus.CONFLICT
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Failed to create project: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
