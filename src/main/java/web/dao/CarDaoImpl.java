package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private static int CARS_COUNT;
    private final List<Car> cars;

    {
        CARS_COUNT = 0;

        cars = new ArrayList<>();

        cars.add(new Car(++CARS_COUNT, 879, "Aptentclass"));
        cars.add(new Car(++CARS_COUNT, 902, "Cubiliaauctor"));
        cars.add(new Car(++CARS_COUNT, 903, "Cabin"));
        cars.add(new Car(++CARS_COUNT, 904, "Cabinet"));
        cars.add(new Car(++CARS_COUNT, 905, "Suscipitmaecenas"));
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        return cars.stream().filter(car -> car.getId() == id).findAny().orElse(null);
    }
}
