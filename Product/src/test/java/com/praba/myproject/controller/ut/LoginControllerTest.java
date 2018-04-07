package com.praba.myproject.controller.ut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.praba.myproject.controller.LoginController;
import com.praba.myproject.model.Login;
import com.praba.myproject.service.LoginService;

@RunWith(SpringRunner.class)
@WebMvcTest({ LoginController.class })
public class LoginControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	LoginService service;

	@Test
	public void testLoginBadRequest_userId_Empty() {
		try {
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
					.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE).param("userId", "").param("password", ""))
					.andReturn();
			assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testLoginOk() {
		try {

			Login login = new Login();
			login.setUserId("junit");
			login.setRole("admin");
			login.setSuccess(true);
			Mockito.when(service.doLogin("junit", "test")).thenReturn(login);
			mockMvc.perform(
					MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
							.param("userId", "junit").param("password", "test"))
					.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
					.andExpect(MockMvcResultMatchers.jsonPath("$.userId").exists());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testLoginNoContent() {
		try {

			Login login = new Login();
			login.setUserId("junit");
			login.setRole("admin");
			login.setSuccess(false);
			Mockito.when(service.doLogin("junit", "test")).thenReturn(login);
			mockMvc.perform(
					MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
							.param("userId", "junit").param("password", "test"))
					.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isNoContent());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testLoginInternalServerError() {
		try {
			Mockito.when(service.doLogin("junit", "test")).thenThrow(Mockito.mock(NullPointerException.class));
			mockMvc.perform(
					MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
							.param("userId", "junit").param("password", "test"))
					.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isInternalServerError());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testLoginBadRequest_password_Empty() {
		try {
			MvcResult result = mockMvc.perform(
					MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
							.param("userId", "junit").param("password", ""))
					.andReturn();
			assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
