package com.example.oAuth2.__MasterClass.Service;

import org.springframework.stereotype.Service;

@Service 
public class PriceCalculatorService {
    public double calculatePrice(double price , double discount){
        if(price<0){
            throw new IllegalArgumentException("Price must be positive");
        }
        if(discount<0 || discount>100){
             throw new IllegalArgumentException();
        }
        return price-((price*discount)/100);
    }
}
