package com.amantii.portfolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amantii.portfolio.dto.ContactRequestDto;
import com.amantii.portfolio.service.ContactService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/contact")
    public ResponseEntity<Void> saveContact(@Valid @RequestBody ContactRequestDto contactRequestDto) {
        contactService.saveContactMessage(contactRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}