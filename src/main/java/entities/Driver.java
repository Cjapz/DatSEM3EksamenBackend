package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity

public class Driver {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String name;
    private String birthYear;
    private String gender;

    @ManyToMany(mappedBy = "driverList")
    private List<Race> raceList = new ArrayList<>();


    public Driver(long id, String name, String birthYear, String gender) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
    }

    public Driver(String name, String birthYear, String gender) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
    }

    public Driver() {

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

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
