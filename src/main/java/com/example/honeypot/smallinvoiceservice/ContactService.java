package com.example.honeypot.smallinvoiceservice;

import com.example.honeypot.model.Contact;
import com.example.honeypot.utils.FieldMapper;
import com.example.smallinvoicespringfeign.model.*;
import com.example.smallinvoicespringfeign.service.SmallInvoiceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ContactService {
    @Autowired
    SmallInvoiceApiService apiService;

    public List<Contact> getContacts() throws IOException {
        List<Contact> contacts = new ArrayList<>();
        List<ContactGET> contactGETS =  apiService.getContacts(null, null);

        for (ContactGET contact: contactGETS) {
            // TODO: 26.11.2021 REPLACE SYSTEM.OUT.PRINTLN WITH ACTUAL LOGGER
            System.out.println("Contact received: " + contact);
            contacts.add(FieldMapper.mapFromJson(FieldMapper.mapToJson(contact), Contact.class));
        }
        return contacts;
    }

    public Contact getContactById(int contactId) throws IOException {
        Contact contact = FieldMapper.mapFromJson(FieldMapper.mapToJson(apiService.getContactById(contactId, null)), Contact.class);
        // TODO: 26.11.2021 REPLACE SYSTEM.OUT.PRINTLN WITH ACTUAL LOGGER
        System.out.println("Contact received: " + contact);
        return contact;
    }


}
