package com.amantii.portfolio.dto;

import java.time.LocalDateTime;

public class ProjectDto {

    private Long id;
    private String title;
    private String description;
    private String githubUrl;
    private String liveUrl;
    private String[] tags;
    private Boolean featured;
    private Integer sortOrder;
    private LocalDateTime createdAt;

    public ProjectDto() {}

    public ProjectDto(Long id, String title, String description, String githubUrl,
                      String liveUrl, String[] tags, Boolean featured,
                      Integer sortOrder, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.githubUrl = githubUrl;
        this.liveUrl = liveUrl;
        this.tags = tags;
        this.featured = featured;
        this.sortOrder = sortOrder;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getGithubUrl() { return githubUrl; }
    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }

    public String getLiveUrl() { return liveUrl; }
    public void setLiveUrl(String liveUrl) { this.liveUrl = liveUrl; }

    public String[] getTags() { return tags; }
    public void setTags(String[] tags) { this.tags = tags; }

    public Boolean getFeatured() { return featured; }
    public void setFeatured(Boolean featured) { this.featured = featured; }

    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
