package br.com.sergiowink.todolist.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
      super(message);
    }
}
