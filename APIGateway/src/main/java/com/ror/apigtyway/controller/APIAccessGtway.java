package com.ror.apigtyway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ror.apigtyway.service.impl.APIGatewayServiceImpl;
import com.ror.model.MessageDetails;
import com.ror.model.RORMessages;
import com.ror.model.RORUser;
import com.ror.vo.RORResponseVO;

@CrossOrigin(origins = "https://ror20.herokuapp.com", maxAge = 3600)
@RestController
@RequestMapping(value = "/rorAPIGateway")
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

	@RequestMapping(value = "/checkUserExist/{id}", method = RequestMethod.GET, produces = "application/json")
	public boolean checkUserExists(@PathVariable("id") String userId) {
		return apiGatewayServiceImpl.checkUserExists(userId);
	}

	@RequestMapping(value = "/messages/received/{id}", method = RequestMethod.GET)
	public @ResponseBody List<MessageDetails> receivedMessage(@PathVariable("id") String id) {
		return apiGatewayServiceImpl.receivedMessage(id);
	}

	@RequestMapping(value = "/messages/draft", method = RequestMethod.POST)
	public @ResponseBody RORResponseVO draftMessage(@RequestBody MessageDetails messageDetails) {
		return apiGatewayServiceImpl.draftMessage(messageDetails);
	}

	@RequestMapping(value = "/messages/details/{id}", method = RequestMethod.GET)
	public @ResponseBody RORMessages messageComepleteDetails(@PathVariable("id") String id) {
		return apiGatewayServiceImpl.messageCompleteDetails(id);
	}

	@RequestMapping(value = "/messages/convo/{u1andu2}", method = RequestMethod.GET)
	public @ResponseBody List<MessageDetails> fetchConversation(@PathVariable("u1andu2") String u1andu2) {
		return apiGatewayServiceImpl.fetchConversation(u1andu2);
	}

}
