package com.daguinci.menumaker_api.auth;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser (User user);
    Optional<User> getUser(String username);
    List<User> getUsers();
}
