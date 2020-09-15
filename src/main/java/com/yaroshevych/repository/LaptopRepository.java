package com.yaroshevych.repository;

import com.yaroshevych.models.Laptop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends CrudRepository<Laptop, Long> {
    List<Laptop> findAllByUsed(boolean used);

    List<Laptop> findByOrderByBrandDesc();

    List<Laptop> findByMemoryGreaterThan(int memory);
}
