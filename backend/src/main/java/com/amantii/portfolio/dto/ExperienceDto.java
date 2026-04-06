package com.amantii.portfolio.dto;

public class ExperienceDto {

    private Long id;
    private String company;
    private String location;
    private String role;
    private String[] roleDescription;
    private String startDate;
    private String endDate;
    private Integer sortOrder;

    public ExperienceDto() {}

    public ExperienceDto(Long id, String company, String location, String role,
                         String[] roleDescription, String startDate, String endDate,
                         Integer sortOrder) {
        this.id = id;
        this.company = company;
        this.location = location;
        this.role = role;
        this.roleDescription = roleDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sortOrder = sortOrder;
    }

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
