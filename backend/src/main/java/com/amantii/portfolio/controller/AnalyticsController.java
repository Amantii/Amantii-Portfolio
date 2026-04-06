package com.amantii.portfolio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amantii.portfolio.dto.PageViewDto;
import com.amantii.portfolio.service.AnalyticsService;

@RestController
@RequestMapping("/api")
public class AnalyticsController {
    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @PostMapping("/views")
    public ResponseEntity<Void> saveView(@RequestBody PageViewDto pageViewDto) {
        analyticsService.savePageView(pageViewDto.getPath(), pageViewDto.getReferrer());
        return ResponseEntity.ok().build();
    }
}