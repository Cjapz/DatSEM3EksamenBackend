package dtos;

import entities.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverDTO {
    private long id;
    private String name;
    private String birthYear;
    private String gender;


    public DriverDTO(Driver rm) {
        this.id = rm.getId();
        this.name = rm.getName();
        this.birthYear = rm.getBirthYear();
        this.gender = rm.getGender();
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

    public static List<DriverDTO> getDtos(List<Driver> rms) {
        List<DriverDTO> rmdtos = new ArrayList();
        rms.forEach(rm -> rmdtos.add(new DriverDTO(rm)));
        return rmdtos;
    }

}
