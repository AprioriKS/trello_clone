package testtask.trelloclone.service.impl;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import testtask.trelloclone.model.Column;
import testtask.trelloclone.model.Task;
import testtask.trelloclone.repository.ColumnRepository;

@ExtendWith(MockitoExtension.class)
class ColumnServiceImplTest {
    @InjectMocks
    private ColumnServiceImpl columnService;

    @Mock
    private ColumnRepository columnRepository;

    @Test
    void changeOrder() {
        Mockito.when(columnRepository.findAll()).thenReturn(List.of(new Column(1L, "Test1", 2,
                List.of(new Task(1L, "Task1", "Testing task", 1, LocalDate.now()), new Task(2L,
                    "Task2", "Testing task", 1, LocalDate.now()))),
            new Column(2L, "Test2", 3,
                List.of(new Task(3L, "Task1", "Testing task", 1, LocalDate.now()), new Task(4L,
                    "Task2", "Testing task", 1, LocalDate.now())))));

        List<Column> all = columnRepository.findAll();

        columnService.changeOrder(all.get(0).getId(), all.get(1).getId());
        Assertions.assertEquals(2, columnRepository.findAll().get(0).getOrder());
        Assertions.assertEquals(1, columnRepository.findAll().get(1).getOrder());

    }
}