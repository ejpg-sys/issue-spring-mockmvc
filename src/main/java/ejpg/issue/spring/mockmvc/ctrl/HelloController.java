/**
 * The MIT License (MIT)
 * Copyright (c) 2024 Eduardo Junior Pereira Garcia
 * 
 * https://github.com/ejpg-sys/issue-spring-mockmvc
 */
package ejpg.issue.spring.mockmvc.ctrl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ejpg.issue.spring.mockmvc.dto.GiftCardDTO;
import ejpg.issue.spring.mockmvc.dto.HelloDTO;

@RestController
public class HelloController {

	@GetMapping(value = "/hello")
	public ResponseEntity<HelloDTO> hello() {
		HelloDTO hello = new HelloDTO(HttpStatus.OK.value(), "Hi, how are you ?");
		return new ResponseEntity<HelloDTO>(hello, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/authorized")
	public ResponseEntity<HelloDTO> authorized(@RequestBody GiftCardDTO gift) {
		if (Integer.valueOf(gift.getNumber()).equals(33884)) {
			HelloDTO hello = new HelloDTO(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.toString());
			return new ResponseEntity<HelloDTO>(hello, HttpStatus.ACCEPTED);
		} else {
			return unauthorized();
		}
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/unauthorized")
	public ResponseEntity<HelloDTO> unauthorized() {
		HelloDTO hello = new HelloDTO(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.toString());
		return new ResponseEntity<HelloDTO>(hello, HttpStatus.UNAUTHORIZED);
	}

}
