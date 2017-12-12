package com.example.cdc.provider.cart.db;

import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, String> {
}
