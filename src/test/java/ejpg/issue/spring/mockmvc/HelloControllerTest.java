/**
 * The MIT License (MIT)
 * Copyright (c) 2024 Eduardo Junior Pereira Garcia
 * 
 * https://github.com/ejpg-sys/issue-spring-mockmvc
 */
package ejpg.issue.spring.mockmvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import ejpg.issue.spring.mockmvc.dto.GiftCardDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Test
	void doHelloWithoutSessionKeyTest(@Autowired MockMvc mvc) throws Exception {
		mvc.perform(get("/hello"))
		.andExpect(status().isUnauthorized());
	}

	@Test
	void doHelloWithWrongSessionKeyTest(@Autowired MockMvc mvc) throws Exception {
		mvc.perform(get("/hello")
				.header("SESSION-KEY", "33885"))
		.andExpect(status().isUnauthorized());
	}

	@Test
	void doHelloWithRightSessionKey(@Autowired MockMvc mvc) throws Exception {
		mvc.perform(get("/hello")
				.header("SESSION-KEY", "33884"))
		.andExpect(status().isOk());
	}

	@Test
	void doAuthorizationWithoutSessionKey(@Autowired MockMvc mvc) throws Exception {
		GiftCardDTO data = new GiftCardDTO();
		data.setNumber(33884);
		byte[] content = new ObjectMapper().writeValueAsBytes(data);
		
		mvc.perform(post("/authorized")
				.contentType("application/json")
				.content(content))
		.andExpect(status().isUnauthorized());
	}

	@Test
	void doAuthorizationWithRightSessionKey(@Autowired MockMvc mvc) throws Exception {
		GiftCardDTO data = new GiftCardDTO();
		data.setNumber(33884);
		byte[] content = new ObjectMapper().writeValueAsBytes(data);
		
		mvc.perform(post("/authorized")
				.header("SESSION-KEY", "33884")
				.contentType("application/json")
				.content(content))
		.andExpect(status().isAccepted());
	}

	@Test
	void doAuthorizationWithRightSessionKeyAndWrongGiftCardNumber(@Autowired MockMvc mvc) throws Exception {
		GiftCardDTO data = new GiftCardDTO();
		data.setNumber(33885);
		byte[] content = new ObjectMapper().writeValueAsBytes(data);
		
		mvc.perform(post("/authorized")
				.header("SESSION-KEY", "33885")
				.contentType("application/json")
				.content(content))
		.andExpect(status().isUnauthorized());
	}

}
