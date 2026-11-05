package com.example.oAuth2.__MasterClass.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oAuth2.__MasterClass.Entity.User;

@Repository 
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByProviderAndProviderSubject(String provider , String providerSubject);
}
