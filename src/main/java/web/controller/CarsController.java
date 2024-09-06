package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;
import web.models.Car;

import java.util.List;


@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarDAO carDAO;

    @Autowired
    public CarsController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping()
    public String printCarsByCount(
            @RequestParam(value = "count", required = false) Integer count,
            Model model) {
        List<Car> cars = carDAO.getLimitedCars(count);
        if (cars.isEmpty()) {
            model.addAttribute("error", "No cars found");
        }
        model.addAttribute("cars", cars);
        return "cars/cars";
    }

    @GetMapping("/{id}")
    public String printCarById(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carDAO.getCarById(id));
        return "cars/carInfo";
    }

}
