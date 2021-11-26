package com.example.honeypot.smallinvoiceservice;

import com.example.honeypot.model.AuthenticatedRemoteUser;
import com.example.honeypot.utils.FieldMapper;
import com.example.honeypot.utils.HasLogger;
import com.example.smallinvoicespringfeign.model.AuthOwnerGET;
import com.example.smallinvoicespringfeign.service.SmallInvoiceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthService implements HasLogger {
    @Autowired
    SmallInvoiceApiService apiService;

    public AuthenticatedRemoteUser getAuthenticatedRemoteUser() throws IOException {
        AuthOwnerGET owner = apiService.getAuthenticatedResourceOwner();
        getLogger().info("AuthOwnerGET received " + owner);
        return FieldMapper.mapFromJson(FieldMapper.mapToJson(owner), AuthenticatedRemoteUser.class);
    }

}
