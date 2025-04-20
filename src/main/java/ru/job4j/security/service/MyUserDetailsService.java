package ru.job4j.security.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.job4j.security.config.MyUserDetails;
import ru.job4j.security.repository.UserRepository;

/**
 * Как и в Spring MVC нужно создать сервис UserDetailsService.
 * Этот сервис будет загружать в SecurityHolder детали
 * авторизованного пользователя.
 * UserDetailsService - реализует управление пользовательскими данными,
 * находит пользователя на основе имени пользователя,
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = service.findByName(username);
        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + "There is not such user in REPO"));
    }

}
