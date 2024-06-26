package com.WebApp.SpringToDo.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("username")
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoSrvice) {
		super();
		this.todoService = todoSrvice;
	}

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String listTodos(ModelMap model) {

		String username = getLoggedInUserName();

		List<Todo> todos = todoService.findByUsername(username);
		model.addAttribute("todos", todos);

		return "listTodos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addNewTodoPage(ModelMap model) {

//		Initializing a todo object in the model to bind the form.
		Todo newTodo = new Todo(0, "hass", "", LocalDate.now(), false);
		model.put("todo", newTodo);

		return "addTodo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "addTodo";
		}

		String username = getLoggedInUserName();

		todoService.addNewToDo(username, todo.getDescription(), todo.getTargetDate());

		return "redirect:/todos";
	}

	@RequestMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id) {

		todoService.deleteTodo(id);

		return "redirect:/todos";

	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodoPage(@RequestParam int id, ModelMap model) {

		Todo todo = todoService.findTodoById(id);
		model.addAttribute("todo", todo);

		return "addTodo";

	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "addTodo";
		}

		String username = getLoggedInUserName();
		todo.setUsername(username);

		todoService.updateTodo(todo);

		return "redirect:/todos";
	}

	private String getLoggedInUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();
	}

}
