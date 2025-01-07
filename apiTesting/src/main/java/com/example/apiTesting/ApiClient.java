package com.example.apiTesting;

import org.springframework.web.client.RestTemplate;

public class ApiClient {

    private final RestTemplate restTemplate;

    public ApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUserById(int userId) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" + userId, User.class);
    }
}
