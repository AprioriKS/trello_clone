package testtask.trelloclone.service.mapper;

import org.springframework.stereotype.Component;
import testtask.trelloclone.dto.request.TaskRequestDto;
import testtask.trelloclone.dto.response.TaskResponseDto;
import testtask.trelloclone.model.Task;

@Component
public class TaskMapper implements RequestDtoMapper<TaskRequestDto, Task>,
        ResponseDtoMapper<Task, TaskResponseDto> {

    @Override
    public Task mapToModel(TaskRequestDto taskRequestDto) {
        Task task = new Task();
        task.setName(taskRequestDto.getName());
        task.setDescription(taskRequestDto.getDescription());
        task.setOrder(taskRequestDto.getOrder());
        task.setDate(taskRequestDto.getDate());
        return task;
    }

    @Override
    public TaskResponseDto mapToDto(Task task) {
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setId(task.getId());
        taskResponseDto.setName(task.getName());
        taskResponseDto.setDescription(task.getDescription());
        taskResponseDto.setOrder(task.getOrder());
        taskResponseDto.setDate(task.getDate());
        return taskResponseDto;
    }
}
