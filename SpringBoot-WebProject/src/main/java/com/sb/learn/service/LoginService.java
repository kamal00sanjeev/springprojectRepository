/**
 * 
 */
package com.sb.learn.service;

import org.springframework.stereotype.Service;

/**
 * @author Sanjeev
 *
 */
@Service
public class LoginService {

	public boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("sanjeev") && password.equalsIgnoreCase("kamal");
	}

}
