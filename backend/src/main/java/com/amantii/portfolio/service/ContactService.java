package com.amantii.portfolio.service;

import org.springframework.stereotype.Service;

import com.amantii.portfolio.dto.ContactRequestDto;
import com.amantii.portfolio.entity.ContactMessage;
import com.amantii.portfolio.repository.ContactRepository;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void saveContactMessage(ContactRequestDto contactRequestDto) {
        ContactMessage contactMessage = new ContactMessage();
        contactMessage.setName(contactRequestDto.getName());
        contactMessage.setEmail(contactRequestDto.getEmail());
        contactMessage.setMessage(contactRequestDto.getMessage());
        contactRepository.save(contactMessage);
    }
}