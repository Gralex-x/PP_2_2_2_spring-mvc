package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CarDAO {

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

    public List<Car> getLimitedCars(int limit) {
        if (limit < 0) {
            return Collections.emptyList();
        }
        return cars.stream().limit(limit).toList();
    }

    public Car getCarById(int id) {
        return cars.stream().filter(car -> car.getId() == id).findAny().orElse(null);
    }
}
