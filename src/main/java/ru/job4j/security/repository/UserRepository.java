package ru.job4j.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.security.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByName(String userName);
}
