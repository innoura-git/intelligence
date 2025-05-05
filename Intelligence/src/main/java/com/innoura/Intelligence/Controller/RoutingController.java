package com.innoura.Intelligence.Controller;

import com.innoura.Intelligence.Entity.ProjectDetails;
import com.innoura.Intelligence.Entity.ServiceDetails;
import com.innoura.Intelligence.Service.IntelligenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/innoura")
public class RoutingController
{
    @Autowired
    private IntelligenceService intelligenceService;

    @PostMapping("/newServiceDeployment")
    public ResponseEntity<String> save( @RequestHeader("X-url") String url, @RequestHeader("X-user") String user, @RequestHeader("X-service-name") String serviceName){
        intelligenceService.saveServiceDetails(url,user,serviceName);
        return ResponseEntity.ok("New Service Deployed ");
    }

    @GetMapping("/checkService")
    public ResponseEntity<List<ServiceDetails>> check(@RequestHeader("X-user") String user){
       List<ServiceDetails> services = intelligenceService.checkUserService(user);
        return ResponseEntity.ok(services);
    }

    @PostMapping("/addProjects")
    public ResponseEntity<String> saveProjects (@RequestBody ProjectDetails projectDetails){
        intelligenceService.saveProjectDetails(projectDetails);
        return ResponseEntity.ok("Project Details saved");
    }

    @GetMapping("/getProjectDetails")
    public ResponseEntity<String> getProjectDetails(@RequestHeader("X-project")String project){
        return ResponseEntity.ok(intelligenceService.getProjectDetails(project));
    }


}
