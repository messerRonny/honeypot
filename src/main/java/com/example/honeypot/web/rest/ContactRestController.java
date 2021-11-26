package com.example.honeypot.web.rest;

import com.example.honeypot.model.Contact;
import com.example.honeypot.smallinvoiceservice.ContactService;
import com.example.honeypot.web.exception.InternalServerError;
import com.example.honeypot.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/contacts/{contactId}")
    public Contact getContactById(@PathVariable Integer contactId){
        try {
            // TODO: 26.11.2021 REPLACE SYSTEM.OUT.PRINTLN WITH ACTUAL LOGGER
            System.out.println("received API call for getContactByID with ID: " + contactId);
            Contact contact = contactService.getContactById(contactId);
            if (contact == null)
                throw new ResourceNotFoundException("Authenticated remote user not found");
            return contact;

        } catch (Exception ex){
            // TODO: 26.11.2021 REPLACE SYSTEM.OUT.PRINTLN WITH ACTUAL LOGGER
            System.out.println("getContactById Error: " + ex.getMessage());
            throw new InternalServerError("Internal Error at getContactById");
        }
    }
/*
    @PutMapping("contacts/{contactId}")
    public Contact updateContact(@RequestBody Contact contact, @PathVariable Integer contactId){
        if (contact.getId() != contactId)
            throw new InternalServerError("Internal Error at updateContact: ID Missmatch");

        try {
            // TODO: 26.11.2021 REPLACE SYSTEM.OUT.PRINTLN WITH ACTUAL LOGGER
            System.out.println("received API call for updateContact with ID: " + contactId);


    }
*/
    //@PostMapping("/contacts")

}
