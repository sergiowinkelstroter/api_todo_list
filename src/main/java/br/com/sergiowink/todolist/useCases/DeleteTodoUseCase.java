package br.com.sergiowink.todolist.useCases;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.todolist.entity.TodoEntity;
import br.com.sergiowink.todolist.repository.TodoRepository;

@Service
public class DeleteTodoUseCase {
    
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ListAllTodoUseCase listAllTodoUseCase;

    public List<TodoEntity> execute(UUID id) {
        this.todoRepository.deleteById(id);
        return this.listAllTodoUseCase.execute();
    }
}
