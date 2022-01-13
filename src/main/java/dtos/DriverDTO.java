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

    public static List<DriverDTO> getDtos(List<Driver> rms) {
        List<DriverDTO> rmdtos = new ArrayList();
        rms.forEach(rm -> rmdtos.add(new DriverDTO(rm)));
        return rmdtos;
    }



}
