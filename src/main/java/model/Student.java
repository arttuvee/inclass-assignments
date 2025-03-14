package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private AikidoRank rank;
    private LocalDate createdAt;

    @ManyToMany(mappedBy = "students")
    private List<TrainingSession> trainingSessions;

    public Student() {}

    public Student(String name, String email, AikidoRank rank, LocalDate createdAt) {
        this.name = name;
        this.email = email;
        this.rank = rank;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public AikidoRank getRank() { return rank; }
    public LocalDate getCreatedAt() { return createdAt; }
    public List<TrainingSession> getTrainingSessions() { return trainingSessions; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setRank(AikidoRank rank) { this.rank = rank; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
    public void setTrainingSessions(List<TrainingSession> trainingSessions) { this.trainingSessions = trainingSessions; }
}