package br.com.sergiowink.todolist.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.todolist.entity.TodoEntity;
import br.com.sergiowink.todolist.repository.TodoRepository;

@Service
public class CreateTodoUseCase {
    
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ListAllTodoUseCase listAllTodoUseCase;

    public List<TodoEntity> execute(TodoEntity todo) {
        this.todoRepository.save(todo);
        return this.listAllTodoUseCase.execute();
    }
}
