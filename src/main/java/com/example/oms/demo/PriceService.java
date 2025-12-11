package com.example.oms.demo;

public class PriceService {

    private final DiscountService discountService;

    public PriceService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public int calculatePrice(int basePrice) {
        if (basePrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        int discount = discountService.getDiscount();
        if ((basePrice - discount) < 0) {
            throw new IllegalArgumentException("Price after discount cannot be negative");
        }
        return basePrice - discount;
    }
}

