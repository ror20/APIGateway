package com.ror.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Servlet Filter implementation class RORFilter
 */
@Component
public class RORFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public RORFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("Enabling CORS!!");
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		HttpServletRequest request1 = (HttpServletRequest) request;

		httpResponse.setHeader("Access-Control-Allow-Origin", "https://ror20.herokuapp.com");
	        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        	httpResponse.setHeader("Access-Control-Allow-Headers", "X-Auth-Token, Content-Type");
	        httpResponse.setHeader("Access-Control-Expose-Headers", "custom-header1, custom-header2");
        	httpResponse.setHeader("Access-Control-Allow-Credentials", "false");
	        httpResponse.setHeader("Access-Control-Max-Age", "4800");
		chain.doFilter(request, httpResponse);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
