package com.example.cdc.provider.cart.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Cart {
    private final List<CartItem> items;

    public Cart(Collection<CartItem> items) {
        this.items = Collections.unmodifiableList(new ArrayList<>(items));
    }

    public List<CartItem> getItems() {
        return items;
    }
}
