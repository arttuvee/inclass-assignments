import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LibraryDao dao = new LibraryDao();

        // Create sample data
        Author author = new Author();
        author.setName("Author Name");

        Biography biography = new Biography();
        biography.setDetails("Biography Details");
        biography.setAuthor(author);
        author.setBiography(biography);

        EBook ebook = new EBook();
        ebook.setTitle("EBook Title");
        ebook.setDownloadUrl("http://example.com/download");

        PrintedBook printedBook = new PrintedBook();
        printedBook.setTitle("Printed Book Title");
        printedBook.setIsbn("1234567890");

        Student student = new Student();
        student.setName("Student Name");

        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBorrowDate(LocalDate.now());
        borrowedBook.setStudent(student);
        borrowedBook.setBook(ebook);

        student.getBorrowedBooks().add(borrowedBook);

        // Persist data
        dao.save(author);
        dao.save(ebook);
        dao.save(printedBook);
        dao.save(student);

        System.out.println("Data inserted successfully.");
    }
}