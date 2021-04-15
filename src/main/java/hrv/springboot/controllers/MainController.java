package hrv.springboot.controllers;

import hrv.springboot.model.Car;
import hrv.springboot.model.Passport;
import hrv.springboot.model.Person;
import hrv.springboot.model.Service;
import hrv.springboot.service.CarService;
import hrv.springboot.service.PassportService;
import hrv.springboot.service.PersonService;
import hrv.springboot.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    PersonService personService;
    @Autowired
    PassportService passportService;
    @Autowired
    CarService carService;
    @Autowired
    ServiceService serviceService;

    @GetMapping("/")
    public String initPage(Model model) {
        List<Person> people = personService.findAll();
        model.addAttribute("people", people);
        return "index";
    }

    @GetMapping("/newPerson")
    public String newPerson() {
        return "newPerson";
    }

    @PostMapping("/person/create")
    public String create(
            @RequestParam String fname,
            @RequestParam String lname,
            @RequestParam int age,
            @RequestParam String SerialNumber

    ) {
        Person person = new Person(fname, lname, age);
        Passport passport = new Passport(SerialNumber);
        personService.save(person);
        passport.setPerson(person);
        passportService.save(passport);
        return "redirect:/";
    }

    @GetMapping("/person/{id}")
    public String getPerson(
            @PathVariable int id,
            Model model
    ) {
        Optional<Person> byId = personService.findById(id);
        if (byId.isPresent()==true) {
            Person person = byId.get();
            model.addAttribute("person", person);
        }else {
            return "problem";
        }
        return "Person";
    }

    @GetMapping("/person/{id}/addCar")
    public String addCar(
            @PathVariable int id,
            Model model) {
        Optional<Person> byId = personService.findById(id);
        Person person = byId.get();
        model.addAttribute("person", person);
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "car";
    }

    @PostMapping("/person/{id}/addCar/choiceCar")
    public String choiceCar(
            @PathVariable int id,
            @RequestParam String car_id
    ){
        int i = Integer.parseInt(car_id);
        Optional<Person> byId = personService.findById(id);
        Optional<Car> byId1 = carService.findById(i);
        Person person = byId.get();
        Car car = byId1.get();
        car.setPerson(person);
        carService.flush(car);
        return "redirect:/";
    }

    @GetMapping("/newCar")
    public String newCar(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("cars",cars);
        return "newCar";
    }

    @PostMapping("car/create")
    public String carCreate(
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam int graduation_year
    ){
        Car car = new Car(brand, model, graduation_year);
        carService.save(car);
        return "redirect:/car/create";
    }

    @GetMapping("/carService")
    public String carService(Model model){
        List<Service> serviceList = serviceService.findAll();
        model.addAttribute("service",serviceList);
        return "carService";
    }

}
