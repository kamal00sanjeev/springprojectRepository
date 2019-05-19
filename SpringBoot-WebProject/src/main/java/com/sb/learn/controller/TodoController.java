/**
 * 
 */
package com.sb.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sb.learn.service.StudentTodoService;

/**
 * @author Sanjeev
 *
 */
@Controller
@SessionAttributes("name")
@RequestMapping(value = { "/app" })
public class TodoController {

	@Autowired
	StudentTodoService service;

	@GetMapping(value = "/list-todos")
	public String showTodos(ModelMap model) {
		String name = (String) model.get("name");
		model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}

}
