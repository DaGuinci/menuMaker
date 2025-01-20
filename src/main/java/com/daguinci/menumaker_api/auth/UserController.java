package com.daguinci.menumaker_api.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{username}")
    public Optional<User> getUser(String username) {
        return userService.getUser(username);
    }

    @PostMapping("/users/add")
    public void addUser(@RequestBody User user) {
        if (user.getRole() == null) {
            user.setRole(Role.USER);
        }
        userService.saveUser(user);
    }
}
