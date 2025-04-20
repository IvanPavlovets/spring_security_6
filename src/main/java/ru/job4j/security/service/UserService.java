package ru.job4j.security.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.security.domain.User;
import ru.job4j.security.repository.UserRepository;

import java.util.Optional;

@Service // сервис слой приложения, тут пишеться бизнесс логика
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByName(String userName) {
        return this.userRepository.findByName(userName);
    }

}
