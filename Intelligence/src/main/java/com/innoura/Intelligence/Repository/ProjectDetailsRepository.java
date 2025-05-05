package com.innoura.Intelligence.Repository;

import com.innoura.Intelligence.Entity.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails,Long>
{
    List<ProjectDetails> findByProjectName(String projectName);
}
