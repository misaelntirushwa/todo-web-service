package dev.misael.todowebservice.repository;

import dev.misael.todowebservice.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoItem, Long> {
}
