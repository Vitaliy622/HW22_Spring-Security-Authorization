package com.yaroshevych.conroller;

import com.yaroshevych.models.Laptop;
import com.yaroshevych.models.User;
import com.yaroshevych.repository.LaptopRepository;
import com.yaroshevych.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Map;

@Controller
public class MainController {
   @Autowired
    private LaptopRepository laptopRepository;
   @Autowired
    private LaptopService laptopService;

    @GetMapping("/")
    public String hello(Map<String,Object> model){
        return  "hello";
    }

    @GetMapping("main")
    public String main(Map<String,Object >model){
        Iterable<Laptop>laptops= laptopRepository.findAll();
        model.put("laptops",laptops);
        return "main";
    }
    @PostMapping("main")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String model,
                      @RequestParam String brand,
                      @RequestParam String cpu,
                      @RequestParam int memory,
                      @RequestParam boolean used,
                      @RequestParam String material,
                      @RequestParam BigDecimal price,
                      @RequestParam int year,
                      Map<String,Object >models){

        Laptop laptop= new Laptop(model,brand,cpu,memory,used,material,price,year);
        laptopRepository.save(laptop);
        Iterable<Laptop>laptops= laptopRepository.findAll();
        models.put("laptops",laptops);
        return "main";
    }
    @PostMapping("filter")
    public String findLaptopsByMemoryGreaterThen(@RequestParam int filter, Map<String,Object>model){
        Iterable<Laptop>laptops;
            laptops=laptopService.showLaptopsByMemoryGreaterThan(filter);
        model.put("laptops",laptops);
        return "main";
    }
    @PostMapping("sortByBrand")
    public String sortByBrand(Model model){
        //Iterable<Laptop>laptops;
       // laptops=laptopRepository.findByOrderByBrandDesc();
        model.addAttribute("laptops", laptopService.sortByBrand());
        return "/main";
    }
    @PostMapping("showUsedLaptops")
    public String showUsedLaptops(Model model){
        model.addAttribute("laptops",laptopService.showUsedLaptops(true));
        return "/main";
    }
}
