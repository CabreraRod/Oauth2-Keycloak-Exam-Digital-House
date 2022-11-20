package com.digitalmedia.users.repository;

import com.digitalmedia.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class KeycloakUserRepository implements IUserRepository{
    @Autowired
    private Keycloak keycloak;


    @Override
    public User validateAndGetUser(String username) {
        return null;
    }

    @Override
    public Optional<User> getUserExtra(String username) {
        return Optional.empty();
    }

    @Override
    public User saveUserExtra(User userExtra) {
        return null;
    }

    @Override
    public List<User> getAllUserMongoDB() {
        return null;
    }
}
