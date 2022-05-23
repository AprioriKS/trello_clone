package testtask.trelloclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import testtask.trelloclone.model.Column;

@Component
public interface ColumnRepository extends JpaRepository<Column, Long> {
}