package entities;

import dtos.RaceDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Race {
    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String name;
    private String date;
    private String time;
    private String location;

    @ManyToMany
    private List<Car> carList= new ArrayList<>();

    public Race() {
    }

    public Race(long id, String name, String date, String time, String location) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public Race(String name, String date, String time, String location) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
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

    public String getLocation(){
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}