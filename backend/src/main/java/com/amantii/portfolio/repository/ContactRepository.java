package com.amantii.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amantii.portfolio.entity.ContactMessage;


@Repository
public interface ContactRepository extends JpaRepository<ContactMessage, Long> {

    List<ContactMessage> findAllByOrderBySentAtDesc();
}