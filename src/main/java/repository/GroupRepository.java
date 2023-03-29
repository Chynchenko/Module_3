package repository;
import DTO.AverageMarkAndStudentCountDTO;
import model.Group;
import utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class GroupRepository {
    private static GroupRepository instance;

    private GroupRepository() {
    }

    public static GroupRepository getInstance() {
        if (instance == null) {
            instance = new GroupRepository();
        }
        return instance;
    }

    public List<Group> findGroupByName(String name) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.createQuery(
                        "SELECT c FROM Group c WHERE c.name LIKE :custName", Group.class)
                .setParameter("custName", "%" + name + "%")
                .getResultList();
    }

    public static List<AverageMarkAndStudentCountDTO> averageMarkEveryGroup() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.createQuery(
                        "SELECT new DTO.StringDoubleDTO (d.name, AVG(k.value)) " +
                                "FROM Group d JOIN d.students e JOIN e.marks k GROUP BY d.name",
                        AverageMarkAndStudentCountDTO.class)
                .getResultList();
    }
}
