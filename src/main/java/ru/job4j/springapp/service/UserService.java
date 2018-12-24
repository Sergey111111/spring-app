package ru.job4j.springapp.service;

import ru.job4j.springapp.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}