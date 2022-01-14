package facades;

import dtos.RaceDTO;
import entities.Race;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class RaceFacade {

    public RaceFacade() {
    }

    private static RaceFacade instance;
    private static EntityManagerFactory emf;

    public List<RaceDTO> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Race> query = em.createQuery("SELECT p FROM Race p", Race.class);
        List<Race> rms = query.getResultList();
        return RaceDTO.getDtos(rms);
    }

    public static RaceFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RaceFacade();
        }
        return instance;
    }

    public RaceDTO create(RaceDTO raceDTO) {
        Race race =
                new Race(raceDTO.getName(), raceDTO.getDate(), raceDTO.getTime(), raceDTO.getLocation());

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(race);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new RaceDTO(race);

    }
}
