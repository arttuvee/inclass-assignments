import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LibraryDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");

    public void save(Object entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    // CRUD operations for Student, Book, and BorrowedBook
}