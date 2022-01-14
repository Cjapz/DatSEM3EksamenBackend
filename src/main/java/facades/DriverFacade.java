package facades;

import dtos.DriverDTO;
import entities.Driver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class DriverFacade {

    public DriverFacade() {
    }

    private static DriverFacade instance;
    private static EntityManagerFactory emf;

    public List<DriverDTO> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Driver> query = em.createQuery("SELECT p FROM Driver p", Driver.class);
        List<Driver> rms = query.getResultList();
        return DriverDTO.getDtos(rms);
    }

    public List<DriverDTO> getDriversByRace(long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Driver> query = em.createQuery("SELECT  d FROM Driver d INNER JOIN d.raceList h WHERE h.id = :id", Driver.class);
        query.setParameter("id", id);
        List<Driver> rms = query.getResultList();
        return DriverDTO.getDtos(rms);
    }

    public static DriverFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new DriverFacade();
        }
        return instance;
    }

}

