package ru.job4j.springapp.dao;

import ru.job4j.springapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
