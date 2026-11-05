package com.example.oAuth2.__MasterClass.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.example.oAuth2.__MasterClass.Entity.User;
import com.example.oAuth2.__MasterClass.Repository.UserRepository;

@Service 
public class UserService {
    @Autowired 
    private UserRepository userRepository;

    public User registerOrUpdate(String provider, OidcUser oidcUser){
        String providerSubject=oidcUser.getSubject();

        String name=oidcUser.getClaimAsString("name");
        String email=oidcUser.getClaimAsString("email");

        Optional<User> existingUser=userRepository.findByProviderAndProviderSubject(provider, providerSubject);
        if(existingUser.isPresent()){
            User user=existingUser.get();
            user.setUserName(name);
            user.setEmail(email);

            return user;
        }

        return userRepository.save(new User(name, email, provider, providerSubject));
    }
}
