package testtask.trelloclone.dto.request;

import java.util.List;
import lombok.Data;
import testtask.trelloclone.model.Task;

@Data
public class ColumnsRequestDto {
    private String name;
    private int order;
    private List<Task> task;
}
