package com.example.honeypot.smallinvoiceservice;

import com.example.honeypot.model.Contact;
import com.example.honeypot.utils.FieldMapper;
import com.example.smallinvoicespringfeign.model.ContactGET;
import com.example.smallinvoicespringfeign.service.SmallInvoiceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {
    @Autowired
    SmallInvoiceApiService apiService;

    public List<Contact> getContacts() throws IOException {
        List<Contact> contacts = new ArrayList<>();
        List<ContactGET> contactGETS =  apiService.getContacts(null, null);

        for (ContactGET contact: contactGETS) {
            System.out.println("Contact received: " + contact);
            contacts.add(FieldMapper.mapFromJson(FieldMapper.mapToJson(contact), Contact.class));
        }
        return contacts;
    }

}
