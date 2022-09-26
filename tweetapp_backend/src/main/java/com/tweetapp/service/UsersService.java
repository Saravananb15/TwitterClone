package com.tweetapp.service;

import com.tweetapp.request.UserRequest;
import com.tweetapp.response.UserResponse;

public interface UsersService {

	UserResponse getAllUsers();

	UserResponse register(UserRequest request);

	UserResponse forgetPassword(UserRequest request);

	UserResponse searchUsers(String username);

}
