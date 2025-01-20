package com.daguinci.menumaker_api.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service @Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository UserRepository;

    public UserServiceImpl(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public User saveUser(User User) {
        return UserRepository.save(User);
    }

    @Override
    public Optional<User> getUser(String username) {
        return UserRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return UserRepository.findAll();
    }
}
