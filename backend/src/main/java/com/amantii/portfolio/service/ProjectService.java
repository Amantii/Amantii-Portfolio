package com.amantii.portfolio.service;

import com.amantii.portfolio.dto.ProjectDto;
import com.amantii.portfolio.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAllByOrderBySortOrderAsc()
                .stream()
                .map(p -> new ProjectDto(
                        p.getId(),
                        p.getTitle(),
                        p.getDescription(),
                        p.getGithubUrl(),
                        p.getLiveUrl(),
                        p.getTags(),
                        p.getFeatured(),
                        p.getSortOrder(),
                        p.getCreatedAt()
                ))
                .toList();
    }
}
