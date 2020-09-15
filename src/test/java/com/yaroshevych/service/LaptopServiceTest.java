package com.yaroshevych.service;

import com.yaroshevych.models.Laptop;
import com.yaroshevych.repository.LaptopRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@SpringBootTest
class LaptopServiceTest {

    @InjectMocks
    static private LaptopService laptopService;
    @Mock
    private LaptopRepository laptopRepositoryMock;
    private final List<Laptop> laptopList = List.of(new Laptop( "XPS 17", "DELL", "Core i7-1065G7", 64, false, "plastic", new BigDecimal("1500.00"), 2020),
            new Laptop( "ROG G", "Asus", "Core i7-9750h", 8, true, "plastic", new BigDecimal("1100.00"), 2019),
            new Laptop( "Macbook pro", "Apple", "Core i7-9750h", 16, false, "metal", new BigDecimal("2000.00"), 2020),
            new Laptop( "X541NA", "Asus", "Pentium n4200", 4, true, "plastic", new BigDecimal("250.00"), 2010),
            new Laptop( "Legion 5", "Lenovo", "Intel Core i7-10750H", 16, false, "plastic", new BigDecimal("1400.00"), 2020),
            new Laptop( "RedmiBook 16 Ryzen", "Xiaomi", "AMD Ryzen 7 4700U", 16, false, "plastic", new BigDecimal("900.00"), 2020),
            new Laptop( "Creator 15", "MSI", "Core i7-10875H", 32, true, "plastic", new BigDecimal("1300.00"), 2020),
            new Laptop( "ThinkPad X1 Extreme", "Lenovo", "Core i9-10885H", 64, true, "plastic", new BigDecimal("1200.00"), 2020),
            new Laptop("Mi Notebook Pro", "Xiaomi", "Intel Core i5-8250U", 16, false, "metal", new BigDecimal("900.00"), 2019),
            new Laptop( "Omen 15", "HP", "AMD Ryzen 7 4800H", 8, false, "plastic", new BigDecimal("980.00"), 2018),
            new Laptop( "TUF Gaming", "ASUS", "AMD Ryzen 5 3550H", 8, true, "plastic", new BigDecimal("1000.00"), 2020),
            new Laptop( "GT72 2QD", "MSI", "i7-4720HQ", 16, true, "plastic", new BigDecimal("1000.00"), 2016),
            new Laptop( "VivoBook S15", "ASUS", "AMD Ryzen 7 4700U", 8, true, "plastic", new BigDecimal("980.00"), 2020),
            new Laptop( "ConceptD 7", "Acer", "Core i7-1065G7", 16, false, "plastic", new BigDecimal("1300.00"), 2020),
            new Laptop( "ROG GL753VD-GC041T", "Asus", "Core i7 7700HQ", 8, true, "plastic", new BigDecimal("700.00"), 2016),
            new Laptop( "MateBook D 14", "Huawei", "Intel Core i5-8250U", 16, false, "plastic", new BigDecimal("900.00"), 2020),
            new Laptop( "MACBOOK AIR", "APPLE", "Cor i5-10300H", 16, false, "metal", new BigDecimal("1000.00"), 2020),
            new Laptop( "ZenBook Pro Duo", "Asus", "Core i7 1065G7", 32, false, "plastic", new BigDecimal("1300.00"), 2020),
            new Laptop( "Omen 17-an198ms", "HP", "Core i7-8750H", 16, true, "plastic", new BigDecimal("1200.00"), 2017),
            new Laptop( "Nitro 5", "Acer", "Core i5-9300H", 16, true, "plastic", new BigDecimal("800.00"), 2018));

    @BeforeAll
    static void beforeAll() {
        laptopService = new LaptopService();
    }

    @Test
    void shouldSaveLaptop() {
        Laptop laptop = new Laptop();
        laptopService.saveLaptop(laptop);
        verify(laptopRepositoryMock).save(laptop);
    }

    @Test
    void showAllLaptops() {
        Mockito.doReturn(laptopList)
                .when(laptopRepositoryMock)
                .findAll();
        Assert.assertSame(laptopService.showAllLaptops(), laptopList);
        Mockito.verify(laptopRepositoryMock).findAll();
    }

    @Test
    void showUsedLaptops() {
        laptopService.showUsedLaptops(true);
        verify(laptopRepositoryMock).findAllByUsed(true);
    }

    @Test
    void sortByBrand() {
        laptopService.sortByBrand();
        verify(laptopRepositoryMock).findByOrderByBrandDesc();
    }

    @Test
    void showLaptopsByMemoryGreaterThan() {
        laptopService.showLaptopsByMemoryGreaterThan(16);
        verify(laptopRepositoryMock).findByMemoryGreaterThan(16);
    }
}