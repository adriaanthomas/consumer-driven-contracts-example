package com.example.cdc.consumer.cartcheckbatch.services.cart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cart {
    private List<CartItem> items;

    protected Cart() {
        // for json
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
