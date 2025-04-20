package ru.job4j.security.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.security.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    //private final UserService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "This is unprotected page";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String pageForUser() {
        return "This page only for users";
    }

    @GetMapping("/admins")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String pageForAdmins() {
        return "This page only for admins";
    }

    @GetMapping("/all")
    public String pageForAll() {
        return "This page for all employees";
    }


}
