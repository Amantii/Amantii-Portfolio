package com.amantii.portfolio.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "page_views")
public class PageView {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="path", length=255)
    private String path;
    
    @Column(name="referrer", length=255)
    private String referrer;

    @Column(name="visited_at", updatable=false)
    private LocalDateTime visitedAt;

    @PrePersist
    protected void onCreate() {
        this.visitedAt = LocalDateTime.now();
    }

    //Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public String getReferrer() { return referrer; }
    public void setReferrer(String referrer) { this.referrer = referrer; }

    public LocalDateTime getVisitedAt() { return visitedAt; }
    public void setVisitedAt(LocalDateTime visitedAt) { this.visitedAt = visitedAt; }
}