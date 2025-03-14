package DAO;

import model.Instructor;
import jakarta.persistence.EntityManager;
import java.util.List;

public class InstructorDAO extends GenericDAO<Instructor> {
    public InstructorDAO(EntityManager entityManager) {
        super(Instructor.class, entityManager);
    }

    public List<Instructor> findInstructorsBySpecialization(String specialization) {
        return entityManager.createQuery(
                        "SELECT i FROM Instructor i WHERE i.specialization = :specialization", Instructor.class)
                .setParameter("specialization", specialization)
                .getResultList();
    }
}