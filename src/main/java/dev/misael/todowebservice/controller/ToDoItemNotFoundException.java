package dev.misael.todowebservice.controller;

public class ToDoItemNotFoundException extends RuntimeException {

    public ToDoItemNotFoundException(Long id) {
        super("To Do item with ID " + id + " could not be found");
    }
}
