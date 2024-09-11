package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getLimitedCars(int limit) {
        return carDao.getAllCars().stream().limit(limit).toList();
    }

    @Override
    public Car getCarById(int id) {
        return carDao.getCarById(id);
    }
}
