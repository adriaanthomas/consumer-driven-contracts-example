package com.example.cdc.provider.cart.db;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    private String id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "cart_user_id", nullable = false)
    private Cart cart;

    protected CartItem() {
        // for JPA
    }

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

    public Cart getCart() {
        return cart;
    }

    /* package */void setCart(Cart cart) {
        this.cart = cart;
    }
}
