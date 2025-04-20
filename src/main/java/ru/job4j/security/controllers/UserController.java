package ru.job4j.security.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Класс контроллера с простыми конечными точками,
 * доступными по различным правам доступа:
 * /welcome — страница доступна всем без авторизации;
 * /users — страница для пользователей с правами ROLE_USER в базе данных;
 * /admins — страница для пользователей с правами ROLE_ADMIN в базе данных;;
 * /all — для всех, но после авторизации.
 */
@RestController
@RequestMapping("/users")
public class UserController {


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
