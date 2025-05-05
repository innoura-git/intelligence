package com.innoura.Intelligence.Service;

import com.innoura.Intelligence.Entity.ProjectDetails;
import com.innoura.Intelligence.Entity.ServiceDetails;
import com.innoura.Intelligence.Repository.ProjectDetailsRepository;
import com.innoura.Intelligence.Repository.ServiceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntelligenceService
{

    @Autowired
    private ServiceDetailsRepository serviceDetailsRepository;

    @Autowired
    private  ProjectDetailsRepository projectDetailsRepository;

    public void saveServiceDetails(String url, String userName, String serviceName){
        ServiceDetails serviceDetails = new ServiceDetails();
        serviceDetails.setUrl(url);
        serviceDetails.setUserName(userName);
        serviceDetails.setServiceName(serviceName);
        serviceDetailsRepository.save(serviceDetails);
    }

    public List<ServiceDetails> checkUserService(String userName){
        List<ServiceDetails> userServices = serviceDetailsRepository.findByUserName(userName);
        return userServices;
    }

    public void saveProjectDetails(ProjectDetails projectDetails){
        projectDetailsRepository.save(projectDetails);
    }

    public String getProjectDetails(String project){
        List<ProjectDetails> projectDetails = projectDetailsRepository.findByProjectName(project);
        System.out.println(projectDetails.toString());
        if(!projectDetails.isEmpty()){
            String projects = projectDetails.getFirst().getServiceNames().toString();
            projects = projects.replaceAll("^\\[|]$", "");
            return projects;
        }
        return "No Service Found for that Projects";
    }

}
