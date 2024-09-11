package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;

import java.util.List;


@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarService carServiceImpl;

    @Autowired
    public CarsController(CarService carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping()
    public String printCarsByCount(
            @RequestParam(value = "count", required = false) Integer count,
            Model model) {
        if(count == null) {
            count = Integer.MAX_VALUE;
        }
        model.addAttribute("cars", carServiceImpl.getLimitedCars(count));
        return "cars/cars";
    }

    @GetMapping("/{id}")
    public String printCarById(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carServiceImpl.getCarById(id));
        return "cars/carInfo";
    }

}
