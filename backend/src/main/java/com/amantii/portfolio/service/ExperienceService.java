package com.amantii.portfolio.service;

import com.amantii.portfolio.dto.ExperienceDto;
import com.amantii.portfolio.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<ExperienceDto> getAllExperiences() {
        return experienceRepository.findAllByOrderBySortOrderAsc()
                .stream()
                .map(e -> new ExperienceDto(
                        e.getId(),
                        e.getCompany(),
                        e.getLocation(),
                        e.getRole(),
                        e.getRoleDescription(),
                        e.getStartDate(),
                        e.getEndDate(),
                        e.getSortOrder()
                ))
                .toList();
    }
}
