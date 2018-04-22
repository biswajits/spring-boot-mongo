package com.mongo.mongodemomongotemplate.service;

import java.util.List;

import com.mongo.mongodemomongotemplate.model.User;

public interface UserService {
	
	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);

	Object getAllUserSettings(String userId);

	String getUserSetting(String userId, String key);

	String addUserSetting(String userId, String key, String value);

}
