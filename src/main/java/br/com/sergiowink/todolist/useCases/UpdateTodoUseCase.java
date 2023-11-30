package br.com.sergiowink.todolist.useCases;

import java.util.List;
import java.util.UUID;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.todolist.entity.TodoEntity;
import br.com.sergiowink.todolist.repository.TodoRepository;


@Service
public class UpdateTodoUseCase {
    
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ListAllTodoUseCase listAllTodoUseCase;

    public List<TodoEntity> execute(UUID id, TodoEntity todo) {
        this.todoRepository.findById(id).ifPresentOrElse((existingTodo) -> {
            todo.setId(id);
            todoRepository.save(todo);
          }, () -> {
            try {
                throw new BadRequestException("Todo %d não existe! ".formatted(id));
            } catch (BadRequestException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
          });
      
          return this.listAllTodoUseCase.execute();
    }
}
