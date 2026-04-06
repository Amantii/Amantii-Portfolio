package com.amantii.portfolio.dto;

public class PageViewDto {

    private String path;

    private String referrer;

    public PageViewDto() {}

    public PageViewDto(String path, String referrer) {
        this.path = path;
        this.referrer = referrer;
    }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public String getReferrer() { return referrer; }
    public void setReferrer(String referrer) { this.referrer = referrer; }
}