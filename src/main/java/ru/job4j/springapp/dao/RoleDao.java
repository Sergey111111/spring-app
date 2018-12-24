package ru.job4j.springapp.dao;

import ru.job4j.springapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {

}
