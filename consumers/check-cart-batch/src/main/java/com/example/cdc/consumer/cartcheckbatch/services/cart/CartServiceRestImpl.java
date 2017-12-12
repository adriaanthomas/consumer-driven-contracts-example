package com.example.cdc.consumer.cartcheckbatch.services.cart;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class CartServiceRestImpl implements CartService {
    private final URI baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public CartServiceRestImpl(String baseUrl) {
        try {
            this.baseUrl = new URI(baseUrl + "/cart");
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("baseUrl invalid: " + baseUrl, e);
        }
    }

    @Override
    public Cart getCart(String userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-UserId", userId);
        RequestEntity<String> req = new RequestEntity<String>(headers, HttpMethod.GET, baseUrl);

        return restTemplate.exchange(req, Cart.class).getBody();
    }
}
