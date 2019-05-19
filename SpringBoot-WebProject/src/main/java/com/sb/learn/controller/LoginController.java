/**
 * 
 */
package com.sb.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sb.learn.service.LoginService;

/**
 * @author Sanjeev
 *
 */
@Controller
@SessionAttributes("name")
@RequestMapping(value = { "/app" })
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping(value = "/")
	@ResponseBody
	public String checkSuccess(ModelMap model) {
		return "Check -- Success!";
	}

	@GetMapping(value = "/login")
	public String showLoginPage(ModelMap model) {
		return "login";
	}

	@PostMapping("/login")
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean isValidUser = loginService.validateUser(name, password);
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		model.put("name", name);
		model.put("pass", password);

		return "welcome";
	}

}
