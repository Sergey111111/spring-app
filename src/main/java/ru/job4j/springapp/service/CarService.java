package ru.job4j.springapp.service;

import ru.job4j.springapp.model.Car;

import java.util.List;

public interface CarService {

    void save(Car car);

    List<Car> findAll();
}
