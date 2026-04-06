package com.amantii.portfolio.controller;

import com.amantii.portfolio.dto.ExperienceDto;
import com.amantii.portfolio.service.ExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/experiences")
    public ResponseEntity<List<ExperienceDto>> getExperiences() {
        return ResponseEntity.ok(experienceService.getAllExperiences());
    }
}
