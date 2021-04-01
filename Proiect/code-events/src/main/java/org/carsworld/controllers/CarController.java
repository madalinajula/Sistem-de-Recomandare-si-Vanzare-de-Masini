package org.carsworld.controllers;

import com.mysql.jdbc.SocketFactoryWrapper;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.util.UtilClassLoader;
import org.carsworld.data.CarRepository;
import org.carsworld.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

@Controller
@RequestMapping("cars")

public class CarController {

    private final Class<SocketFactoryWrapper> aClass = SocketFactoryWrapper.class;
    
    @Autowired
    private CarRepository carRepository;

    @Around("index")
    @GetMapping("index")
    public String displayAllEvents(Model model) {
        model.addAttribute("title","All cars");
        model.addAttribute("cars", carRepository.findAll());
        return "cars/index";
    }
    @Around("create")
    @GetMapping("create")
    public String displayCreateCarForm(Model model){
        model.addAttribute("title","Create car");
        return "cars/create";
    }

    @PostMapping("create")
    public String processCreateCarForm(@ModelAttribute Car newCar){
        carRepository.save(newCar);
        return "cars/create";
    }

    @Around("search")
    @GetMapping("search")
    public String displaySearchCarForm(Model model){
        model.addAttribute("title","Search");
        return "cars/search";
    }
    @PostMapping("search")
    public String processSearchCarForm(Model model,@RequestParam(required = false) Integer price,@RequestParam(required = false) Integer price2) throws InterruptedException {

        ArrayList<Car> carsList = new ArrayList<Car>();
        Car carsList2[] = new Car[50];
        int carsNr = 0;
        Iterator cars = carRepository.findAll().iterator();
        for (Iterator it = cars; it.hasNext(); ) {
            Car c = (Car) it.next();
            if (c.getPrice() >= price && c.getPrice() <= price2) {
                carsList2[carsNr] = c;
                carsNr++;
                carRepository.save(c);
            }
        }
        for (int i = 0; i < carsNr - 1; i++)
            for (int j = i + 1; j < carsNr; j++)
                if (carsList2[i].getGrade() < carsList2[j].getGrade()) {
                    Car aux = new Car();
                    aux = carsList2[i];
                    carsList2[i] = carsList2[j];
                    carsList2[j] = aux;
                }
        for (int i = 0; i < carsNr; i++) {
            carsList.add(carsList2[i]);
        }
        model.addAttribute("cars", carsList);

        return "cars/search";
    }

    @Around("update")
    @GetMapping("update")
    public String displayUpdateCarForm(Model model){
        model.addAttribute("title","Create car");
        model.addAttribute("cars",carRepository.findAll());
        return "cars/update";
    }

    @Around("update")
    @PostMapping("update")
    public String processUpdateCarForm(@RequestParam(required = false) int[] carIds ,@ModelAttribute Car newCar) {
        Iterator cars=carRepository.findAll().iterator();
        for (Iterator it = cars; it.hasNext(); ) {
            Car c = (Car) it.next();
            for (int id : carIds) {
                System.out.println(c.getId()+" " + c.getCompany()+ " "+id);
                if(id == c.getId()){
                    c.setGrade((newCar.getGrade()+c.getGrade())/2);
                    carRepository.save(c);
                }
            }


        }
        return "cars/update";
    }

    @Around("buy")
    @GetMapping("buy")
    public String displayBuyCarForm(Model model){
        model.addAttribute("title","Buy car");
        model.addAttribute("cars",carRepository.findAll());
        return "cars/buy";
    }

    @Around("buy")
    @PostMapping("buy")
    public String processBuyCarForm(Model model,@RequestParam(required = false) int[] carIds ) throws InterruptedException {

        ArrayList<Car> carsList =new ArrayList<Car>();
        if (carIds != null) {
            for (int id : carIds) {
                for (Car car:carRepository.findAll())
                    if(car.getId()==id){
                        // System.out.println(car.getId());
                        carsList.add(car);
                        //   model.addAttribute("cars",carsList);
                    }

            }
        }
        model.addAttribute("cars",carsList);
        return "cars/buy";
    }

    @Around("delete")
    @GetMapping("delete")
    public String displayDeleteCarForm(Model model){
        model.addAttribute("title","Delete Cars");
        model.addAttribute("cars",carRepository.findAll());
        return "cars/delete";
    }

    @Around("delete")
    @PostMapping("delete")
    public String processDeleteCarsForm(@RequestParam(required = false) int[] carIds )
    {    if (carIds != null) {
        for (int id : carIds) {
            carRepository.deleteById(id);

        }
    }
        return "cars/delete";

    }
}
