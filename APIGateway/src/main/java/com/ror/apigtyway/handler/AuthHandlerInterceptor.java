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
			System.out.println("Auth header is present allowing request");
			if (authHeader.toLowerCase().contains(BASIC)) {
				System.out.println("basic is present");
				String tokens[] = authHeader.split(" ");
				byte[] decodedToken = Base64.getDecoder().decode(tokens[1]);
				String userNamePass = new String(decodedToken);
				return true;
			}
		} else {
			System.out.println("Auth header is not present make sure you set the Auth header and send");
		}
		response.setStatus(401);
		return false;
	}
}
