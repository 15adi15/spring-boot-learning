package com.example.oAuth2.__MasterClass.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oAuth2.__MasterClass.Entity.Product;

@Repository 
public interface ProductRepository extends JpaRepository<Product, Long> {
}

