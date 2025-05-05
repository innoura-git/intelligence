package com.innoura.Intelligence.Controller;

import com.innoura.Intelligence.Entity.ProjectInformation;
import com.innoura.Intelligence.Service.IntelligenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/innoura")
public class RoutingController
{
    @Autowired
    private IntelligenceService intelligenceService;

    @GetMapping("/getProjectServices")
    public ResponseEntity<String> checkForServices(@RequestHeader("X-project") String projectName){
        String services = intelligenceService.checkProjectService(projectName);
        return ResponseEntity.ok(services);
    }
    @PostMapping("/setProjectServices")
    public ResponseEntity<String> createNewProject(@RequestBody ProjectInformation projectInformation)
    {
        return intelligenceService.createNewProject(projectInformation);
    }

}
