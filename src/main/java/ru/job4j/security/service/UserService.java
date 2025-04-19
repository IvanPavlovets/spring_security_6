package ru.job4j.security.service;

import ru.job4j.security.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserByName(String userName);
}
