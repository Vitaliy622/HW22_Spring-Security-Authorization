package com.yaroshevych.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Data
@Table(name="laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;
    private String brand;
    private String cpu;
    private int memory;
    private boolean used;
    private String material;
    private BigDecimal price;
    private int year;

    public Laptop( String model, String brand, String cpu, int memory, boolean used, String material, BigDecimal price, int year) {
        this.model = model;
        this.brand = brand;
        this.cpu = cpu;
        this.memory = memory;
        this.used = used;
        this.material = material;
        this.price = price;
        this.year = year;
    }

    public Laptop() {

    }
}
