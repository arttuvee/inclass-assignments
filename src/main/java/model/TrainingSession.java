package model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "training_sessions")
public class TrainingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;
    private LocalDateTime sessionDate;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany
    @JoinTable(
            name = "student_training_session",
            joinColumns = @JoinColumn(name = "training_session_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public TrainingSession() {}

    public TrainingSession(String topic, LocalDateTime sessionDate, Instructor instructor) {
        this.topic = topic;
        this.sessionDate = sessionDate;
        this.instructor = instructor;
    }

    public Long getId() { return id; }
    public String getTopic() { return topic; }
    public LocalDateTime getSessionDate() { return sessionDate; }
    public Instructor getInstructor() { return instructor; }
    public List<Student> getStudents() { return students; }

    public void setTopic(String topic) { this.topic = topic; }
    public void setSessionDate(LocalDateTime sessionDate) { this.sessionDate = sessionDate; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
    public void setStudents(List<Student> students) { this.students = students; }
}