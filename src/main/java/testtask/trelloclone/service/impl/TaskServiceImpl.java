package testtask.trelloclone.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import testtask.trelloclone.model.Column;
import testtask.trelloclone.model.Task;
import testtask.trelloclone.repository.ColumnRepository;
import testtask.trelloclone.repository.TaskRepository;
import testtask.trelloclone.service.TaskService;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ColumnRepository columnRepository;

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public void changeColumns(Long ColumnIdFrom, Long ColumnIdTo, int idFrom) {
        Column columnFrom = columnRepository.findById(ColumnIdFrom).get();
        Column columnTo = columnRepository.findById(ColumnIdTo).get();
        columnTo.getTask().add(columnFrom.getTask().get(idFrom));
        columnFrom.getTask().remove(idFrom);
        columnRepository.save(columnFrom);
        columnRepository.save(columnTo);
    }

    @Override
    public void changeOrder(Long idFrom, Long idTo, int orderFrom, int orderTo) {
        Task from = findById(idFrom);
        Task to = findById(idTo);
        int tempOrder = from.getOrder();
        from.setOrder(to.getOrder());
        to.setOrder(tempOrder);
        save(from);
        save(to);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }


}

