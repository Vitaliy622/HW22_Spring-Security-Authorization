package com.yaroshevych.service;

import com.yaroshevych.models.Laptop;
import com.yaroshevych.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService  {
    @Autowired
    private LaptopRepository laptopRepository;

    public void saveLaptop(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    public List<Laptop> showAllLaptops() {
        return (List<Laptop>) laptopRepository.findAll();
    }

    public List<Laptop> showUsedLaptops(boolean used) {
        return laptopRepository.findAllByUsed(used);
    }

    public List<Laptop> sortByBrand() {
        return laptopRepository.findByOrderByBrandDesc();
    }

    public List<Laptop> showLaptopsByMemoryGreaterThan(int memory) {
        return laptopRepository.findByMemoryGreaterThan(memory);
    }
}
