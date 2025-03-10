import javax.persistence.Entity;

@Entity
public class PrintedBook extends Book {
    private String isbn;

    // Getters and setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}