package DAO;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Student;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class StudentDAO extends GenericDAO<Student> {
    public StudentDAO(EntityManager entityManager) {
        super(Student.class, entityManager);
    }


    public List<Student> findStudentsWithRecentProgressReports() {
        LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);
        return entityManager.createQuery(
                        "SELECT DISTINCT s FROM Student s JOIN s.progressReports pr WHERE pr.reportDate >= :threeMonthsAgo", Student.class)
                .setParameter("threeMonthsAgo", threeMonthsAgo)
                .getResultList();
    }

    public List<Student> findStudentsByRank(String rank) {
        return entityManager.createQuery(
                        "SELECT s FROM Student s WHERE s.rank = :rank", Student.class)
                .setParameter("rank", rank)
                .getResultList();
    }

    public List<Student> findStudentsJoinedInLastSixMonths() {
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> student = cq.from(Student.class);
        cq.select(student).where(cb.greaterThanOrEqualTo(student.get("joinDate"), sixMonthsAgo));
        return entityManager.createQuery(cq).getResultList();
    }

}