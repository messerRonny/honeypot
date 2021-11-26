package com.example.honeypot.web.rest;

import com.example.honeypot.model.Contact;
import com.example.honeypot.smallinvoiceservice.ContactService;
import com.example.honeypot.web.exception.InternalServerError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContactRestController{

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        try {
            // TODO: 26.11.2021 REPLACE SYSTEM.OUT.PRINTLN WITH ACTUAL LOGGER
            System.out.println("received API call for getContacts");
            return contactService.getContacts();

        } catch (Exception ex) {
            // TODO: 26.11.2021 REPLACE SYSTEM.OUT.PRINTLN WITH ACTUAL LOGGER
            System.out.println("getContacts Error: " + ex.getMessage());
            throw new InternalServerError("Internal Error at getContacts");
        }
    }
}
