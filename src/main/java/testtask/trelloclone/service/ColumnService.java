package testtask.trelloclone.service;

import java.util.List;
import testtask.trelloclone.model.Column;
import testtask.trelloclone.model.Task;

public interface ColumnService {

    Column findById(Long id);

    List<Column> getAll();

    Column save(Column column);

    void changeOrder(Long idFrom, Long idTo);

    void deleteById(Long id);
}

