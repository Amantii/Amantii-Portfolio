package com.amantii.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amantii.portfolio.entity.PageView;

@Repository
public interface PageViewRepository extends JpaRepository<PageView, Long> {

    List<PageView> findAllByOrderByVisitedAtDesc();
}