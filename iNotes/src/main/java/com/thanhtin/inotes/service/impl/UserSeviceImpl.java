package com.thanhtin.inotes.service.impl;

import com.thanhtin.inotes.model.User;
import com.thanhtin.inotes.repository.UserRepository;
import com.thanhtin.inotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSeviceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User user) {
    userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
    userRepository.delete(id);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
