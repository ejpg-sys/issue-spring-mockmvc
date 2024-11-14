/**
 * The MIT License (MIT)
 * Copyright (c) 2024 Eduardo Junior Pereira Garcia
 * 
 * https://github.com/ejpg-sys/issue-spring-mockmvc
 */
package ejpg.issue.spring.mockmvc.filter;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
@Order(1)
public class HelloFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String sessionKey = req.getHeader("SESSION-KEY");
		
		if (sessionKey != null && sessionKey.equals("33884")) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/unauthorized").forward(request, response);
			chain.doFilter(request, response);
		}

	}

}
