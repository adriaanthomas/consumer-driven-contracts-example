package com.example.cdc.consumer.cartcheckbatch.services.cart;

import au.com.dius.pact.consumer.*;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.MockProviderConfig;
import au.com.dius.pact.model.PactFragment;
import au.com.dius.pact.model.RequestResponsePact;
import com.example.cdc.consumer.cartcheckbatch.PactSettings;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CartServiceRestImplPactTest {
    @Rule
    public final PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("cart", this);

    @Pact(consumer = PactSettings.CONSUMER_NAME)
    public RequestResponsePact createFragmentForUnknownUser(PactDslWithProvider builder) {
        return builder
            .given("no user with id 'notKnown' exists")
            .uponReceiving("a request for the current cart")
                .path("/cart")
                .method("GET")
                .headers(Collections.singletonMap("X-UserId", "notKnown"))
            .willRespondWith()
                .status(200)
                .matchHeader("Content-Type", "application/json;\\s*charset=UTF-8", "application/json; charset=UTF-8")
                .body("{\"items\": []}")
            .toPact();
    }

    @Pact(consumer = PactSettings.CONSUMER_NAME)
    public RequestResponsePact createFragmentForCartWithOneItem(PactDslWithProvider builder) {
        return builder
            .given("a user with id 'abc' with a cart with a single item")
            .uponReceiving("a request for the current cart")
                .path("/cart")
                .method("GET")
                .headers(Collections.singletonMap("X-UserId", "abc"))
            .willRespondWith()
                .status(200)
                .matchHeader("Content-Type", "application/json;\\s*charset=UTF-8", "application/json; charset=UTF-8")
                .body(new PactDslJsonBody()
                    .array("items")
                        .object()
                            .stringValue("id", "IDC12")
                            .numberValue("quantity", 1)
                            .numberValue("quantity", 1)
                            .numberValue("price", 4995)
                            .numberValue("stock", 15)
                        .closeObject()
                    .closeArray()
                )
            .toPact();
    }

    @Test
    @PactVerification(fragment = "createFragmentForUnknownUser")
    public void testUnknownUser() {
        // arrange
        final CartService service = new CartServiceRestImpl(mockProvider.getUrl());

        // act
        final Cart cart = service.getCart("notKnown");

        // assert
        assertNotNull(cart);
        assertNotNull(cart.getItems());
        assertTrue(cart.getItems().isEmpty());
    }

    @Test
    @PactVerification(fragment = "createFragmentForCartWithOneItem")
    public void testCartWithOneItem() {
        // arrange
        final CartService service = new CartServiceRestImpl(mockProvider.getUrl());

        // act
        final Cart cart = service.getCart("abc");

        // assert
        assertNotNull(cart);
        assertNotNull(cart.getItems());
        assertEquals(1, cart.getItems().size());

        CartItem item = cart.getItems().get(0);
        assertNotNull(item);
        assertEquals("IDC12", item.getId());
        assertEquals(1, item.getQuantity());
        assertEquals(4995, item.getPrice());
        assertEquals(15, item.getStock());
    }
}
