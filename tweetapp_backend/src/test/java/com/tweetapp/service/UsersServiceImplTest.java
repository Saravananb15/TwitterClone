//package com.tweetapp.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.bson.types.ObjectId;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.SpyBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.HttpServerErrorException.InternalServerError;
//
//import com.tweetapp.config.TweetConfigTest;
//import com.tweetapp.dto.UsersDto;
//import com.tweetapp.entities.UsersEntity;
//import com.tweetapp.repo.UsersRepo;
//import com.tweetapp.request.UserRequest;
//import com.tweetapp.response.UserResponse;
//import com.tweetapp.service.impl.UsersServiceImpl;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = UsersServiceImpl.class)
//@ContextConfiguration(classes = TweetConfigTest.class)
//public class UsersServiceImplTest {
//
//	@SpyBean
//	private UsersServiceImpl usersServiceImpl;
//
//	@MockBean
//	UsersRepo usersRepo;
//
//	@Test
//	public void getAllUsersTest() {
//		UserResponse response = new UserResponse();
//		response.setStatusMessage("SUCCESS");
//		List<String> roles = new ArrayList<>();
//		List<UsersEntity> users = new ArrayList<>();
//		UsersEntity entity = new UsersEntity();
//		entity.setContactNumber("9999");
//		entity.setEmailId("fin@mail.com");
//		entity.setFirstName("fin");
//		entity.setLastName("fin");
//		entity.setLoggedIn(true);
//		entity.setLoginId("fin");
//		entity.setObjectId(new ObjectId());
//		entity.setPassword("pwd");
//		entity.setRoles(roles);
//		users.add(entity);
//		Mockito.when(usersRepo.findAll()).thenReturn(users);
//		UserResponse expectedResponse = usersServiceImpl.getAllUsers();
//		assertEquals(response.getStatusMessage(), expectedResponse.getStatusMessage());
//
//	}
//	
//	@Test
//	public void getAllUsersTestFailure() {
//		UserResponse response = new UserResponse();
//		response.setStatusMessage("FAILURE");
//		Mockito.when(usersRepo.findAll()).thenThrow(InternalServerError.class);
//		UserResponse expectedResponse = usersServiceImpl.getAllUsers();
//		assertEquals(response.getStatusMessage(), expectedResponse.getStatusMessage());
//
//	}
//	
//	@Test
//	public void registerTest() {
//		UserResponse response = new UserResponse();
//		response.setStatusMessage("SUCCESS");
//		List<String> roles = new ArrayList<>();
//		List<UsersEntity> users = new ArrayList<>();
//		UserRequest request = new UserRequest();
//		UsersDto entity = new UsersDto();
//		entity.setContactNumber("9999");
//		entity.setEmailId("fin@mail.com");
//		entity.setFirstName("fin");
//		entity.setLastName("fin");
//		entity.setLoggedIn(true);
//		entity.setLoginId("fin");
//		entity.setPassword("pwd");
//		request.setUserDto(entity);
//		//Mockito.when(usersRepo.findAll()).thenReturn(users);
//		UserResponse expectedResponse = usersServiceImpl.register(request);
//		assertEquals(response.getStatusMessage(), expectedResponse.getStatusMessage());
//
//	}
//	
//	@Test
//	public void registerTestException() {
//		UserResponse response = new UserResponse();
//		response.setStatusMessage("FAILURE");
//		List<String> roles = new ArrayList<>();
//		List<UsersEntity> users = new ArrayList<>();
//		UserRequest request = new UserRequest();
//		UsersDto dto = new UsersDto();
//		dto.setContactNumber("9999");
//		dto.setEmailId("fin@mail.com");
//		dto.setFirstName("fin");
//		dto.setLastName("fin");
//		dto.setLoggedIn(true);
//		dto.setLoginId("fin");
//		dto.setPassword("pwd");
//		request.setUserDto(dto);
//		Mockito.when(usersRepo.findByLoginId(dto.getLoginId())).thenThrow(InternalServerError.class);
//		UserResponse expectedResponse = usersServiceImpl.register(request);
//		assertEquals(response.getStatusMessage(), expectedResponse.getStatusMessage());
//
//	}
//	
//	@Test
//	public void forgetPasswordTest() {
//		UserResponse response = new UserResponse();
//		response.setStatusMessage("SUCCESS");
//		List<String> roles = new ArrayList<>();
//		List<UsersEntity> users = new ArrayList<>();
//		UserRequest request = new UserRequest();
//		UsersDto dto = new UsersDto();
//		dto.setContactNumber("9999");
//		dto.setEmailId("fin@mail.com");
//		dto.setFirstName("fin");
//		dto.setLastName("fin");
//		dto.setLoggedIn(true);
//		dto.setLoginId("fin");
//		dto.setPassword("pwd");
//		request.setUserDto(dto);
//		UsersEntity entity = new UsersEntity();
//		entity.setContactNumber("9999");
//		entity.setEmailId("fin@mail.com");
//		entity.setFirstName("fin");
//		entity.setLastName("fin");
//		entity.setLoggedIn(true);
//		entity.setLoginId("fin");
//		entity.setObjectId(new ObjectId());
//		entity.setPassword("pwd");
//		entity.setRoles(roles);
//		Mockito.when(usersRepo.findByLoginId(dto.getLoginId())).thenReturn(entity);
//		UserResponse expectedResponse = usersServiceImpl.forgetPassword(request);
//		assertEquals(response.getStatusMessage(), expectedResponse.getStatusMessage());
//
//	}
//	
//	@Test
//	public void forgetPasswordTest2() {
//		UserResponse response = new UserResponse();
//		response.setStatusMessage("USER NOT FOUND");
//		List<String> roles = new ArrayList<>();
//		List<UsersEntity> users = new ArrayList<>();
//		UserRequest request = new UserRequest();
//		UsersDto dto = new UsersDto();
//		dto.setContactNumber("9999");
//		dto.setEmailId("fin@mail.com");
//		dto.setFirstName("fin");
//		dto.setLastName("fin");
//		dto.setLoggedIn(true);
//		dto.setLoginId("fin");
//		dto.setPassword("pwd");
//		request.setUserDto(dto);
//		Mockito.when(usersRepo.findByLoginId(dto.getLoginId())).thenReturn(null);
//		UserResponse expectedResponse = usersServiceImpl.forgetPassword(request);
//		assertEquals(response.getStatusMessage(), expectedResponse.getStatusMessage());
//
//	}
//	
//	@Test
//	public void forgetPasswordException() {
//		UserResponse response = new UserResponse();
//		response.setStatusMessage("FAILURE");
//		UserRequest request = new UserRequest();
//		UsersDto dto = new UsersDto();
//		dto.setContactNumber("9999");
//		dto.setEmailId("fin@mail.com");
//		dto.setFirstName("fin");
//		dto.setLastName("fin");
//		dto.setLoggedIn(true);
//		dto.setLoginId("fin");
//		dto.setPassword("pwd");
//		request.setUserDto(dto);
//		Mockito.when(usersRepo.findByLoginId(dto.getLoginId())).thenThrow(InternalServerError.class);
//		UserResponse expectedResponse = usersServiceImpl.forgetPassword(request);
//		assertEquals(response.getStatusMessage(), expectedResponse.getStatusMessage());
//
//	}
//	
//	@Test
//	public void searchUsersTest() {
//		UserResponse response = new UserResponse();
//		response.setStatusMessage("SUCCESS");
//		List<String> roles = new ArrayList<>();
//		List<UsersEntity> users = new ArrayList<>();
//		UsersEntity entity = new UsersEntity();
//		entity.setContactNumber("9999");
//		entity.setEmailId("fin@mail.com");
//		entity.setFirstName("fin");
//		entity.setLastName("fin");
//		entity.setLoggedIn(true);
//		entity.setLoginId("fin");
//		entity.setObjectId(new ObjectId());
//		entity.setPassword("pwd");
//		entity.setRoles(roles);
//		users.add(entity);
//		Mockito.when(usersRepo.searchByIds("finny")).thenReturn(users);
//		UserResponse expectedResponse = usersServiceImpl.searchUsers("finny");
//		assertEquals(response.getStatusMessage(), expectedResponse.getStatusMessage());
//
//	}
//	
//	@Test
//	public void searchUsersTestException() {
//		UserResponse response = new UserResponse();
//		response.setStatusMessage("FAILURE");
//		Mockito.when(usersRepo.searchByIds("finny")).thenThrow(InternalServerError.class);
//		UserResponse expectedResponse = usersServiceImpl.searchUsers("finny");
//		assertEquals(response.getStatusMessage(), expectedResponse.getStatusMessage());
//
//	}
//	
//	
//	
//
//}
