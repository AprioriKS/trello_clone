package testtask.trelloclone.dto.response;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import testtask.trelloclone.model.Task;

@Data
public class ColumnsResponseDto {
    private Long id;
    private String name;
    private int order;
    private List<Task> task;
}
