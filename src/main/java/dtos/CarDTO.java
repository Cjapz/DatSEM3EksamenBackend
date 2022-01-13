package dtos;

import entities.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDTO {
    private long id;
    private String name;
    private String brand;
    private String make;
    private String year;



    public CarDTO(Car rm) {
        this.id = rm.getId();
        this.name = rm.getName();
        this.brand = rm.getBrand();
        this.make = rm.getMake();
        this.year = rm.getYear();
    }


    public CarDTO() {
    }

    public CarDTO(CarDTO carDTO) {
        this.name = carDTO.getName();
        this.brand = carDTO.getBrand();
        this.make = carDTO.getMake();
        this.name = carDTO.getYear();

    }

    public CarDTO(String brand, String make, String name) {
        this.name = name;
        this.brand = brand;
        this.make = make;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public static List<CarDTO> getDtos(List<Car> rms) {
        List<CarDTO> rmdtos = new ArrayList();
        rms.forEach(rm -> rmdtos.add(new CarDTO(rm)));
        return rmdtos;
    }

}
