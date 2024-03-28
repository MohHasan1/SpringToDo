package com.WebApp.SpringToDo.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoSrvice) {
		super();
		this.todoService = todoSrvice;
	}
	

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String listTodos(ModelMap model) {
		
		List<Todo> todos = todoService.findByUsername(null);
		model.addAttribute("todos", todos);
		
		return "listTodos";
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.GET)
	public String addNewTodoPage() {
		return "addTodo";
	}
	
	
	@RequestMapping(value="/add-todo", method = RequestMethod.POST)
	public String addNewTodo(@RequestParam String description, ModelMap model) {
		
		String username = (String)model.get("username");
		
		todoService.addNewToDo(username, description, LocalDate.now().plusWeeks(3));
		
		return "redirect:todos";
	}
}
