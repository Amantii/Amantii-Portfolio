package com.amantii.portfolio.controller;

import com.amantii.portfolio.dto.ProjectDto;
import com.amantii.portfolio.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDto>> getProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }
}
