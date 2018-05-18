package com.ror.apigtyway.handler;

import static com.ror.apigtyway.constants.APIGatewayConstants.AUTHORIZATION;
import static com.ror.apigtyway.constants.APIGatewayConstants.BASIC;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthHandlerInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String authHeader = request.getHeader(AUTHORIZATION);
		System.out.println("The Following host has hit APIGateway" + request.getRequestURL());
		if (authHeader != null && !authHeader.isEmpty()) {
			if (authHeader.toLowerCase().contains(BASIC)) {
				System.out.println("basic is present");
				String tokens[] = authHeader.split(" ");
				byte[] decodedToken = Base64.getDecoder().decode(tokens[1]);
				String userNamePass = new String(decodedToken);
				return true;
			}
		}
		response.setStatus(401);
		return false;
	}
}
