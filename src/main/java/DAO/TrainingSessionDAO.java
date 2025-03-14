package DAO;

import model.TrainingSession;
import model.Student;
import jakarta.persistence.EntityManager;
import java.util.List;

public class TrainingSessionDAO extends GenericDAO<TrainingSession> {
    public TrainingSessionDAO(EntityManager entityManager) {
        super(TrainingSession.class, entityManager);
    }

    public List<TrainingSession> findTrainingSessionsByStudent(Student student) {
        return entityManager.createQuery(
                        "SELECT ts FROM TrainingSession ts JOIN ts.students s WHERE s.id = :studentId", TrainingSession.class)
                .setParameter("studentId", student.getId())
                .getResultList();
    }

    public List<TrainingSession> findTrainingSessionsByLocation(String location) {
        return entityManager.createQuery(
                        "SELECT ts FROM TrainingSession ts WHERE ts.location = :location", TrainingSession.class)
                .setParameter("location", location)
                .getResultList();
    }
}