package com.WebApp.SpringToDo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	public static int todoCount = 0; 
	static {
		todos.add(new Todo(++todoCount, "hass", "learn Spring", LocalDate.now().plusWeeks(3), false));
		todos.add(new Todo(++todoCount, "hass", "work on project", LocalDate.now().plusWeeks(2), false));
		todos.add(new Todo(++todoCount, "hass", "complete assignment", LocalDate.now().plusWeeks(4), false));
	}

	public List<Todo> findByUsername(String username) {
		return todos;
	}
	
	public void addNewToDo(String username, String desc, LocalDate targetdate) {
		
		todos.add(new Todo(++todoCount, username, desc, targetdate, false));
	}
	
	public void deleteTodo(int id) {
		
		
		Predicate<? super Todo> Predicate = todo -> todo.getId() == id;
		todos.removeIf(Predicate);
	}
	
	public Todo findTodoById(int id) {
		
		Predicate<? super Todo> Predicate = todo -> todo.getId() == id;
		Todo existingTodo = todos.stream().filter(Predicate).findFirst().get();
		
		return existingTodo;
	}
	

	public void updateTodo(@Valid Todo todo) {
		
		deleteTodo(todo.getId());
		
		todos.add(todo);
	}
}
