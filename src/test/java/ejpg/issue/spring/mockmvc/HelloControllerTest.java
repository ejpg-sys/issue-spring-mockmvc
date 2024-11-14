/**
 * The MIT License (MIT)
 * Copyright (c) 2024 Eduardo Junior Pereira Garcia
 * 
 * https://github.com/ejpg-sys/issue-spring-mockmvc
 */
package ejpg.issue.spring.mockmvc;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Test
	void doHelloWithoutSessionKeyTest() {
		fail("Not yet implemented!");
	}

	@Test
	void doHelloWithWrongSessionKeyTest() {
		fail("Not yet implemented!");
	}

	@Test
	void doHelloWithRightSessionKey() {
		fail("Not yet implemented!");
	}

	@Test
	void doAuthorizationWithoutSessionKey() {
		fail("Not yet implemented!");
	}

	@Test
	void doAuthorizationWithRightSessionKey() {
		fail("Not yet implemented!");
	}

	@Test
	void doAuthorizationWithRightSessionKeyAndWrongGiftCardNumber() {
		fail("Not yet implemented!");
	}

}
