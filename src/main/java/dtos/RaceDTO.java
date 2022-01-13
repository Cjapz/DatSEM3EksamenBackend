package dtos;

import entities.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceDTO {
    private long id;
    private String name;
    private String date;
    private String time;
    private String location;

    public RaceDTO(Race rm) {
        this.id = rm.getId();
        this.name = rm.getName();
        this.date = rm.getDate();
        this.time = rm.getTime();
        this.location = rm.getLocation();
    }

    public static List<RaceDTO> getDtos(List<Race> rms) {
        List<RaceDTO> rmdtos = new ArrayList();
        rms.forEach(rm -> rmdtos.add(new RaceDTO(rm)));
        return rmdtos;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
