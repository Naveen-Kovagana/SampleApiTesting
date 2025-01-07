package com.example.apiTesting;

import java.util.Optional;

public class UserService {

    private final ApiClient apiClient;

    public UserService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Optional<String> getUserEmail(int userId) {

        try {
            User user = apiClient.getUserById(userId);
            return Optional.ofNullable(user).map(User::getEmail);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }
}
