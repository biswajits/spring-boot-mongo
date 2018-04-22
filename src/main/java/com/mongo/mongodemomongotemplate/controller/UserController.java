package com.mongo.mongodemomongotemplate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.mongodemomongotemplate.model.User;
import com.mongo.mongodemomongotemplate.service.UserService;

@RestController
@RequestMapping(value="/")
public class UserController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		return userService.getUserById(userId);
	}
	
	@RequestMapping(value = "/settings/{userId}/{key}/{value}", method = RequestMethod.GET)
	public String addUserSetting(@PathVariable String userId, @PathVariable String key, @PathVariable String value) {
		LOG.info("Adding user UserSettings ID: {}.", userId);
		return userService.addUserSetting(userId, key, value);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userService.addNewUser(user);
	}
	
	@RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
	public Object getAllUserSettings(@PathVariable String userId, @PathVariable String key) {
		User user = userService.getUserById(userId);
		if (user != null) {
			return userService.getUserSetting(userId, key);
		} else {
			return "User not found.";
		}
	}
}
