package facades;

import dtos.CarDTO;
import dtos.DriverDTO;
import dtos.RaceDTO;
import entities.Car;
import entities.Driver;
import entities.Race;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarFacade {
    public CarFacade() {
    }

    private static CarFacade instance;
    private static EntityManagerFactory emf;

    public static CarFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CarFacade();
        }
        return instance;
    }


    public List<CarDTO> getCarByRace(String name) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Car> query = em.createQuery("SELECT  p FROM Car p INNER JOIN p.raceList h WHERE h.name = :name", Car.class);
        query.setParameter("name", name);
        List<Car> rms = query.getResultList();
        return CarDTO.getDtos(rms);
    }

}

