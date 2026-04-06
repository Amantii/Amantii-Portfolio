package com.amantii.portfolio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String company;

    @Column(length = 100)
    private String location;

    @Column(nullable = false, length = 100)
    private String role;

    @Column(name = "role_description", nullable = false, columnDefinition = "TEXT[]")
    private String[] roleDescription;

    @Column(name = "start_date", nullable = false, length = 20)
    private String startDate;

    @Column(name = "end_date", length = 20)
    private String endDate;

    @Column(name = "sort_order")
    private Integer sortOrder = 0;

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String[] getRoleDescription() { return roleDescription; }
    public void setRoleDescription(String[] roleDescription) { this.roleDescription = roleDescription; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
}
