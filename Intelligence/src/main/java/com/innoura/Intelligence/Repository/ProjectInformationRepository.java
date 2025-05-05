package com.innoura.Intelligence.Repository;

import com.innoura.Intelligence.Entity.ProjectInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectInformationRepository extends JpaRepository<ProjectInformation,Integer> {
    String findByProjectName(String projectName);
}
