/**
 * The MIT License (MIT)
 * Copyright (c) 2024 Eduardo Junior Pereira Garcia
 * 
 * https://github.com/ejpg-sys/issue-spring-mockmvc
 */
package ejpg.issue.spring.mockmvc.dto;

public class HelloDTO {

	private int status;
	private String message;

	public HelloDTO() { }

	public HelloDTO(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
