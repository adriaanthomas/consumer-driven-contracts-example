package com.example.cdc.provider.cart.model;

public class CartItem {
    private final String id;
    private final int quantity;
    private final int price;
    private final String name;
    private final int stock = 15;

    public CartItem(String id, int quantity, int price, String name) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }
}
