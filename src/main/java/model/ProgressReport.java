package model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "progress_reports")
public class ProgressReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String report;
    private LocalDateTime reportDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Version
    private int version;
    public ProgressReport() {}

    public ProgressReport(String report, LocalDateTime reportDate, Student student) {
        this.report = report;
        this.reportDate = reportDate;
        this.student = student;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getReport() { return report; }
    public LocalDateTime getReportDate() { return reportDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public Student getStudent() { return student; }
    public int getVersion() { return version; }

    public void setReport(String report) { this.report = report; }
    public void setReportDate(LocalDateTime reportDate) { this.reportDate = reportDate; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public void setStudent(Student student) { this.student = student; }
}