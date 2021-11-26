package com.example.honeypot.web.rest;


import com.example.honeypot.model.AuthenticatedRemoteUser;
import com.example.honeypot.smallinvoiceservice.AuthService;
import com.example.honeypot.utils.HasLogger;
import com.example.honeypot.web.exception.InternalServerError;
import com.example.honeypot.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthRestController implements HasLogger {

    @Autowired
    private AuthService authService;

    @GetMapping("/resource-owner")
    public AuthenticatedRemoteUser getAuthenticatedRemoteUser() {
        try {
            getLogger().info("get resource-owner received call");
            AuthenticatedRemoteUser resourceOwner = authService.getAuthenticatedRemoteUser();
            if (resourceOwner == null) throw new ResourceNotFoundException("Authenticated remote user not found");
            return resourceOwner;
        } catch (Exception ex) {
            getLogger().info("get resource-owner error " + ex.getMessage());
            throw new InternalServerError("Internal Error at get authenticated remote user");
        }


    }
}
