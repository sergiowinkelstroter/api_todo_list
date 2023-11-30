package br.com.sergiowink.todolist.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.sergiowink.todolist.entity.TodoEntity;
import br.com.sergiowink.todolist.repository.TodoRepository;

@Service
public class ListAllTodoUseCase {
    
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoEntity> execute() {
    Sort sort = Sort.by(Direction.DESC, "prioridade")
        .and(Sort.by(Direction.ASC, "id"));
        
        return this.todoRepository.findAll(sort);
    }
}
