package testtask.trelloclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import testtask.trelloclone.model.Task;

@Component
public interface TaskRepository extends JpaRepository<Task, Long> {
}