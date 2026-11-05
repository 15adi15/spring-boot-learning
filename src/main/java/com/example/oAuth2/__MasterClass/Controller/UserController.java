package com.example.oAuth2.__MasterClass.Controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String home() {
        return "Welcome to OAuth 2.0 & OIDC MasterClass! Visit /user to view your authenticated profile.";
    }

    @GetMapping("/user")
    public Map<String, Object> getUser(@AuthenticationPrincipal OidcUser oidcUser) {
        if (oidcUser == null) {
            return Map.of("message", "Not authenticated");
        }
        return Map.of(
            "name", oidcUser.getFullName() != null ? oidcUser.getFullName() : "",
            "email", oidcUser.getEmail() != null ? oidcUser.getEmail() : "",
            "attributes", oidcUser.getAttributes()
        );
    }
}

