package com.example.oAuth2.__MasterClass.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PriceCalculatorServiceTest {

    private PriceCalculatorService priceCalculatorService=new PriceCalculatorService();

    @Test 
    public void shouldApplyDiscountToPrice(){
        //arrange->Inputs
        double price=1000;
        double discount=20;

        //act--Action performed
       double actualPrice= priceCalculatorService.calculatePrice(price, discount);

       //assertion-->Expected output
       assertEquals(800,actualPrice);
    }

}
