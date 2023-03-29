package repository;

import model.Lector;
import utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class LectorRepository {

    private static LectorRepository instance;

    private LectorRepository() {
    }

    public static LectorRepository getInstance() {
        if (instance == null) {
            instance = new LectorRepository();
        }
        return instance;
    }

    public List<Lector> findLectorByName(String name) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.createQuery(
                        "SELECT c FROM Lector c WHERE c.firstName LIKE " +
                                ":custName OR c.surname LIKE :custName", Lector.class)
                .setParameter("custName", name)
                .getResultList();
    }
}