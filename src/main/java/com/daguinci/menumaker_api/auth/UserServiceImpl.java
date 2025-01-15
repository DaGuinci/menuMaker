package com.daguinci.menumaker_api.auth;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service @Transactional
public class UserServiceImpl implements UserService {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(AppUserRepository appUserRepository, RoleRepository roleRepository) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public AppUser saveUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
