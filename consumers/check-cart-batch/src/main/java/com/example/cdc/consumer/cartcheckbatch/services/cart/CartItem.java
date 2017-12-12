package com.example.cdc.consumer.cartcheckbatch.services.cart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartItem {
    private String id;
    private int quantity;
    private int price;
    private int stock;

    protected CartItem() {
        // for json
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
