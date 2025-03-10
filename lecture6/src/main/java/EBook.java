import javax.persistence.Entity;

@Entity
public class EBook extends Book {
    private String downloadUrl;

    // Getters and setters
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}