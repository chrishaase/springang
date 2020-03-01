package com.example.demo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
// @WebMvcTest(controllers = BookController.class)
@AutoConfigureMockMvc
public class ProjectControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenProjectExists_thenGetSuccess() throws Exception {
		mockMvc.perform(get("/api/books/978-3-86490-120-1")
				.contentType("application/json"))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.isbn").value("978-3-86490-120-1"));
	}

}
