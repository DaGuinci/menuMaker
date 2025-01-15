package com.daguinci.menumaker_api.auth;

import java.util.List;

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
    public List<AppUser> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{username}")
    public AppUser getUser(String username) {
        return userService.getUser(username);
    }

    @PostMapping("/users/add")
    public void addUser(@RequestBody AppUser appUser) {
        userService.saveUser(appUser);
    }

    @PostMapping("/users/addRole")
    public void addRoleToUser(String username, String roleName) {
        userService.addRoleToUser(username, roleName);
    }

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return userService.getRoles();
    }

    @PostMapping("/roles/add")
    public void addRole(@RequestBody Role role) {
        userService.saveRole(role);
    }

}
