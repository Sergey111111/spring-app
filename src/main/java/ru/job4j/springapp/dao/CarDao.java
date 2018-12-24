package ru.job4j.springapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.springapp.model.Car;

public interface CarDao extends JpaRepository<Car, Long> {
}
