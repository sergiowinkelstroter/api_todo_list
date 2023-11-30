package br.com.sergiowink.todolist.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sergiowink.todolist.entity.TodoEntity;
import br.com.sergiowink.todolist.useCases.CreateTodoUseCase;
import br.com.sergiowink.todolist.useCases.DeleteTodoUseCase;
import br.com.sergiowink.todolist.useCases.ListAllTodoUseCase;
import br.com.sergiowink.todolist.useCases.UpdateTodoUseCase;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(value  = "/todos")
public class TodoController {

    @Autowired
    private CreateTodoUseCase createTodoUseCase;

    @Autowired
    private ListAllTodoUseCase listAllTodoUseCase;

    @Autowired
    private UpdateTodoUseCase updateTodoUseCase;

    @Autowired 
    private DeleteTodoUseCase deleteTodoUseCase;

    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody TodoEntity todo) {
        try {
            var result = this.createTodoUseCase.execute(todo);
            return ResponseEntity.ok()
                .body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public List<TodoEntity> list() {
        return this.listAllTodoUseCase.execute();
    }

    @PutMapping(value = "/{id}")
    public List<TodoEntity> update(@PathVariable UUID id, @RequestBody TodoEntity todo){
        return this.updateTodoUseCase.execute(id, todo);
    }


    @DeleteMapping(value = "/{id}")
    public List<TodoEntity> delete(@PathVariable UUID id){
        return this.deleteTodoUseCase.execute(id);
    }
    
    
}
