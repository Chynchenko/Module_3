package repository;

import DTO.AverageMarkAndStudentCountDTO;
import DTO.StudentMarkDTO;
import model.Student;
import utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentRepository {
    private static StudentRepository instance;

    private StudentRepository() {
    }

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public void save(Student student) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public static List<AverageMarkAndStudentCountDTO> countStudentsEveryGroup() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.createQuery(
                        "SELECT new DTO.StringLongDTO (d.name, COUNT(*)) " +
                                "FROM Group d JOIN d.students e GROUP BY d.name",
                        AverageMarkAndStudentCountDTO.class)
                .getResultList();
    }

    public List<StudentMarkDTO> findStudentByAvgMark(double value) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.createQuery(
                        "SELECT new DTO.StudentMarkDTO " +
                                "(d.id, d.firstName, d.surname, AVG (k.value)) " +
                                "FROM Student d JOIN d.marks k GROUP BY d.id " +
                                "HAVING AVG (k.value) > " + value, StudentMarkDTO.class)
                .getResultList();
    }
}