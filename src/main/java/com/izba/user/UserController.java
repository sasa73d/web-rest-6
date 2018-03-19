package com.izba.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getUsers(@RequestParam(value="id", defaultValue = "0", required = false) long id) {	
		List<User> users = userService.getUsers(id);
		return users;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@PathVariable long id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, headers = "Accept=application/json")
	public User addUser(@RequestBody User user) {	
		return userService.addUser(user);
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT, headers = "Accept=application/json")
	public User updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return user;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);		
	}	
}
