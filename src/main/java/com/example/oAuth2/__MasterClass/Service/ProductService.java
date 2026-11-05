package com.example.oAuth2.__MasterClass.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.oAuth2.__MasterClass.Entity.Product;
import com.example.oAuth2.__MasterClass.Repository.ProductRepository;

@Service 
public class ProductService {
    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}

