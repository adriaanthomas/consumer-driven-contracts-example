package com.example.cdc.provider.cart.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Converter {
    public com.example.cdc.provider.cart.model.Cart toModel(Cart cart) {
        return cart == null ? new com.example.cdc.provider.cart.model.Cart(Collections.emptyList()) : new com.example.cdc.provider.cart.model.Cart(toModel(cart.getItems()));
    }

    public List<com.example.cdc.provider.cart.model.CartItem> toModel(List<CartItem> items) {
        List<com.example.cdc.provider.cart.model.CartItem> returnValue = new ArrayList<>(items.size());
        for (CartItem item : items) {
            returnValue.add(toModel(item));
        }
        return Collections.unmodifiableList(returnValue);
    }

    public com.example.cdc.provider.cart.model.CartItem toModel(CartItem item) {
        return new com.example.cdc.provider.cart.model.CartItem(item.getId(), item.getQuantity(), item.getPrice(), item.getName());
    }
}
