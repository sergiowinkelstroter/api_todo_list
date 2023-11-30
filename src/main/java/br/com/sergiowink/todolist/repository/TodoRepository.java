package br.com.sergiowink.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sergiowink.todolist.entity.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, UUID>{

}
