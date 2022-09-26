//package com.tweetapp.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.SpyBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.tweetapp.config.TweetConfigTest;
//import com.tweetapp.request.UserRequest;
//import com.tweetapp.response.UserResponse;
//import com.tweetapp.service.UsersService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = UsersController.class)
//@ContextConfiguration(classes = TweetConfigTest.class)
//public class UsersControllerTest {
//
//	@SpyBean
//	UsersController usersController;
//
//	@MockBean
//	UsersService usersService;
//
//	@Test
//	public void getAllUsersTest() {
//		UserResponse userResponse = new UserResponse();
//		userResponse.setStatusMessage("SUCCESS");
//		Mockito.when(usersService.getAllUsers()).thenReturn(userResponse);
//		UserResponse actualResponse = usersController.getAllUsers();
//		assertEquals(userResponse.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//	
//	@Test
//	public void register() {
//		UserResponse userResponse = new UserResponse();
//		UserRequest request = new UserRequest();
//		userResponse.setStatusMessage("SUCCESS");
//		Mockito.when(usersService.register(request)).thenReturn(userResponse);
//		UserResponse actualResponse = usersController.register(request);
//		assertEquals(userResponse.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//	
//	@Test
//	public void forgetPassword() {
//		UserResponse userResponse = new UserResponse();
//		UserRequest request = new UserRequest();
//		userResponse.setStatusMessage("SUCCESS");
//		Mockito.when(usersService.forgetPassword(request)).thenReturn(userResponse);
//		UserResponse actualResponse = usersController.forgetPassword(request);
//		assertEquals(userResponse.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//	
//	@Test
//	public void searchUsers() {
//		UserResponse userResponse = new UserResponse();
//		UserRequest request = new UserRequest();
//		userResponse.setStatusMessage("SUCCESS");
//		Mockito.when(usersService.searchUsers("finny")).thenReturn(userResponse);
//		UserResponse actualResponse = usersController.searchUsers("finny");
//		assertEquals(userResponse.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//}
