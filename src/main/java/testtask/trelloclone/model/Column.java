package testtask.trelloclone.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity(name = "column")
@Data
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Column(name = "id", nullable = false)
    private Long id;

    @javax.persistence.Column(name = "title", nullable = false)
    private String name;

    @javax.persistence.Column(name = "order", nullable = false)
    private int order;

    @OneToMany
    @JoinTable(name = "tasks_list",
        joinColumns = @JoinColumn(name = "column_id"),
        inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> task = new ArrayList<>();

    public Column() {
    }

    public Column(Long id, String name, int order,
        List<Task> task) {
        this.id = id;
        this.name = name;
        this.order = order;
        this.task = task;
    }
}



