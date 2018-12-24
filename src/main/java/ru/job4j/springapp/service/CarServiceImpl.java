package ru.job4j.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.springapp.dao.CarDao;
import ru.job4j.springapp.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarDao carDao;

    @Override
    public void save(Car car) {
        carDao.save(car);
    }

    @Override
    public List<Car> findAll() {
      return   carDao.findAll();
    }
}
