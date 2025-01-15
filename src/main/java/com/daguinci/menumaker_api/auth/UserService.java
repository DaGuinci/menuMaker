package com.daguinci.menumaker_api.auth;

import java.util.List;

public interface UserService {
    AppUser saveUser (AppUser appUser);
    Role saveRole (Role role);
    List<Role> getRoles();
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
