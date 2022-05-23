package testtask.trelloclone.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name = "order", nullable = false)
    private int order;

    @Column(name="data_creation", nullable = false)
    private LocalDate date;

    public Task() {
    }

    public Task(Long id, String name, String description, int order, LocalDate date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.order = order;
        this.date = date;
    }
}
