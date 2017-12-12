package com.example.cdc.provider.cart.controllers;

import com.example.cdc.provider.cart.db.CartRepository;
import com.example.cdc.provider.cart.db.Converter;
import com.example.cdc.provider.cart.model.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/cart")
public class CartController {
    private static final Logger LOG = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartRepository repository;

    private final Converter converter = new Converter();

    @RequestMapping(method = RequestMethod.GET)
    public Cart getCart(@RequestHeader(value = "X-UserId", required = false) String userId) {
        LOG.info("get cart for {}", userId);
        if (userId == null) {
            return converter.toModel(new com.example.cdc.provider.cart.db.Cart(null, Collections.emptyList()));
        }
        return converter.toModel(repository.findOne(userId));
    }
}
