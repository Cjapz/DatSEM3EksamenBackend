package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@NamedQuery(name = "Car.deleteAllRows", query = "DELETE from Car ")
public class Car {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String make;
    private String name;
    private String year;

    @OneToMany
    private List<Race> carList= new ArrayList<>();

    public Car() {
    }

    public Car(long id, String name, String brand, String make, String year) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.make = make;
        this.year = year;
    }

    public Car(String name, String brand, String make, String year) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
