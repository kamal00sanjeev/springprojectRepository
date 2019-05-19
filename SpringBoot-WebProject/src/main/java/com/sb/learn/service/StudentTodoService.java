/**
 * 
 */
package com.sb.learn.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sb.learn.model.StudentTodo;

/**
 * @author Sanjeev
 *
 */
@Service
public class StudentTodoService {

	private static List<StudentTodo> todos = new ArrayList<>();

    static {
        todos.add(new StudentTodo(1, "sanjeev", "Learn Spring MVC", new Date(),
                false));
        todos.add(new StudentTodo(2, "learn", "Learn Struts", new Date(), false));
        todos.add(new StudentTodo(3, "sanjeev", "Learn Hibernate", new Date(),
                true));
        todos.add(new StudentTodo(4, "Thomas", "Learn NodeJS", new Date(),
                true));
    }

    public List<StudentTodo> retrieveTodos(String user) {
    	System.out.println("Retrieve method call...");
        List<StudentTodo> filteredTodos = new ArrayList<>();
        for (StudentTodo todo : todos) {
                filteredTodos.add(todo);
        }
        return filteredTodos;
    }
}
