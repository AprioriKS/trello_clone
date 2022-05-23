package testtask.trelloclone.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import testtask.trelloclone.model.Column;
import testtask.trelloclone.repository.ColumnRepository;
import testtask.trelloclone.service.ColumnService;

@Service
@RequiredArgsConstructor
public class ColumnServiceImpl implements ColumnService {
    private final ColumnRepository columnRepository;

    @Override
    public Column findById(Long id) {
        return columnRepository.findById(id).get();
    }

    @Override
    public List<Column> getAll() {
        return columnRepository.findAll();
    }

    @Override
    public Column save(Column column) {
        return columnRepository.save(column);
    }

    @Override
    public void changeOrder(Long idFrom, Long idTo) {
        Column from = findById(idFrom);
        Column to = findById(idTo);
        int tempOrder = from.getOrder();
        from.setOrder(to.getOrder());
        to.setOrder(tempOrder);
        save(from);
        save(to);
    }

    @Override
    public void deleteById(Long id) {
        columnRepository.deleteById(id);
    }
}
