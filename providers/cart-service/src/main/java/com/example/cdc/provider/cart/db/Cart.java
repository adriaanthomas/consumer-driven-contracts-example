package com.example.cdc.provider.cart.db;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class Cart {
    @Id
    private String userId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<CartItem> items;

    protected Cart() {
        // for JPA
        items = new ArrayList<>();
    }

    public Cart(String userId, Collection<CartItem> items) {
        this.userId = userId;
        this.items = new ArrayList<>(items);
        for (CartItem item : items) {
            item.setCart(this);
        }
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
