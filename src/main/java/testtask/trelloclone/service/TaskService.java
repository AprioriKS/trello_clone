package testtask.trelloclone.service;

import java.util.List;
import testtask.trelloclone.model.Column;
import testtask.trelloclone.model.Task;

public interface TaskService {
    Task findById(Long id);

    Task save(Task category);

    List<Task> getAll();

    void changeColumns(Long ColumnIdFrom, Long ColumnIdTo, int idFrom);

    void changeOrder(Long idFrom, Long idTo, int orderFrom, int orderTo);

    void deleteById(Long id);
}
