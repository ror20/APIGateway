package com.ror.apigtyway.handler;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.ror.apigtyway.constants.APIGatewayConstants.AUTHORIZATION;
import static com.ror.apigtyway.constants.APIGatewayConstants.BASIC;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthHandlerInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String authHeader = request.getHeader(AUTHORIZATION);
		if (authHeader == null) {
			return false;
		}
		if (authHeader.isEmpty()) {
			return false;
		}
		if (authHeader.toLowerCase().contains(BASIC)) {
			String tokens[] = authHeader.split(" ");
			byte[] decodedToken = Base64.getDecoder().decode(tokens[1]);
			String userNamePass = new String(decodedToken);
			return true;
			/*String[] userPass = userNamePass.split(":");
			System.out.println("username is " + userPass[0] + "password is " + userPass[1]);
			if (userPass[0].equals("akash") && userPass[1].equals("akash")) {
				return true;
			}*/
		}
		return false;
	}
}
