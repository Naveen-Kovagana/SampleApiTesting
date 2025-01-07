package com.example.apiTesting;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.swing.text.html.Option;

import java.util.Optional;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

	private ApiClient apiClientMock;
	private UserService userService;

	@Before
	public void setUp() {
		apiClientMock = Mockito.mock(ApiClient.class);
		userService = new UserService(apiClientMock);
	}

	@Test
	public void testGetUserEmail() {

		//Arrange
		User mockUser = new User();
		mockUser.setId(1);
		mockUser.setName("Naveen Kovagana");
		mockUser.setEmail("naveen.kovagana@example.com");

		when(apiClientMock.getUserById(1)).thenReturn(mockUser);

		//Act
		Optional<String> email = userService.getUserEmail(1);

		//Assert
		assertTrue(email.isPresent());
		assertEquals("naveen.kovagana@example.com",email.get());
		verify(apiClientMock, times(1)).getUserById(1);

	}

	@Test
	public void testGetUserEmail_UserNotFound() {

		//Arrange
		when(apiClientMock.getUserById(2)).thenReturn(null);

		//Act
		Optional<String> email = userService.getUserEmail(2);

		//Assert
		assertFalse(email.isPresent());
		verify(apiClientMock, times(1)).getUserById(2);
	}

}