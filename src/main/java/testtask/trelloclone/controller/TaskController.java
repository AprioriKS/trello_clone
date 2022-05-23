package testtask.trelloclone.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import testtask.trelloclone.dto.request.ColumnsRequestDto;
import testtask.trelloclone.dto.request.TaskRequestDto;
import testtask.trelloclone.dto.response.TaskResponseDto;
import testtask.trelloclone.model.Task;
import testtask.trelloclone.service.TaskService;
import testtask.trelloclone.service.mapper.TaskMapper;


@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping("/{id}")
    public TaskResponseDto getById(@PathVariable Long id) {
        Task task = taskService.findById(id);
        return taskMapper.mapToDto(task);
    }

    @PostMapping
    public TaskResponseDto save(@RequestBody TaskRequestDto taskRequestDto) {
        Task task = taskMapper.mapToModel(taskRequestDto);
        Task savedTask = taskService.save(task);
        return taskMapper.mapToDto(savedTask);
    }

    @PutMapping("/{id}")
    public TaskResponseDto update(@PathVariable Long id,
        @RequestBody TaskRequestDto taskRequestDto) {
        Task task = taskMapper.mapToModel(taskRequestDto);
        task.setId(id);
        return taskMapper.mapToDto(taskService.save(task));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteById(id);
    }

    @PostMapping("/changeorder")
    public String changeOrder(@RequestParam Long idFrom,
        @RequestParam Long idTo,
        @RequestParam int orderFrom,
        @RequestParam int orderTo) {
        taskService.changeOrder(idFrom, idTo, orderFrom, orderTo);
        return "Order change successful";
    }

    @PostMapping("/changecolumn")
    public String changeColumns(@RequestParam Long ColumnIdFrom, @RequestParam Long ColumnIdTo,
        @RequestParam int idFrom) {
        taskService.changeColumns(ColumnIdFrom, ColumnIdTo, idFrom);
        return "Column change successful";
    }

    @GetMapping("/all")
    public List<TaskResponseDto> getAll() {
        return taskService.getAll().stream()
            .map(taskMapper::mapToDto)
            .collect(Collectors.toList());
    }

}
