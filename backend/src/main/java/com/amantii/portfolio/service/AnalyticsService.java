package com.amantii.portfolio.service;

import org.springframework.stereotype.Service;

import com.amantii.portfolio.entity.PageView;
import com.amantii.portfolio.repository.PageViewRepository;

@Service
public class AnalyticsService {
    private final PageViewRepository pageViewRepository;

    public AnalyticsService(PageViewRepository pageViewRepository) {
        this.pageViewRepository = pageViewRepository;
    }

    public void savePageView(String path, String referrer) {
        PageView pageView = new PageView();
        pageView.setPath(path);
        pageView.setReferrer(referrer);
        pageViewRepository.save(pageView);
    }
}