package com.ror.apigtyway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ror.apigtyway.service.impl.APIGatewayServiceImpl;
import com.ror.model.RORUser;
import com.ror.vo.RORResponseVO;

@RestController
@RequestMapping(value = "/apiGtway/api")
public class APIAccessGtway {

	@Autowired
	APIGatewayServiceImpl apiGatewayServiceImpl;

	@RequestMapping(value = "/fetchAllUsers", produces = "application/json", method = RequestMethod.GET)
	public List<RORUser> getUser() {
		return apiGatewayServiceImpl.fetchAllUsers();

	}

	@RequestMapping(value = "/fetchUser/{id}", method = RequestMethod.GET, produces = "application/json")
	public RORUser fetchUser(@PathVariable("id") String userId) {
		return apiGatewayServiceImpl.fetchUser(userId);
	}

	@RequestMapping(value = "/storeUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public RORResponseVO storeUser(@RequestBody RORUser rorUser) {
		return apiGatewayServiceImpl.storeUser(rorUser);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public RORResponseVO updateUser(@RequestBody RORUser rorUser) {
		return apiGatewayServiceImpl.updateUser(rorUser);
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public RORResponseVO deleteUser(@PathVariable("id") String userId) {
		return apiGatewayServiceImpl.deleteUser(userId);
	}

}
