package testtask.trelloclone.dto.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class TaskRequestDto {
    private String name;
    private String description;
    private int order;
    private LocalDate date;
}
