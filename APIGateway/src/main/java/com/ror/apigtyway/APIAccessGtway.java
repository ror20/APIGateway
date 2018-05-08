package com.ror.apigtyway;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ror.model.RORUser;

@RestController
@RequestMapping(value = "/apiGtway/api")
public class APIAccessGtway {

	@Autowired
	RestTemplate restTemplate;

	@Value("${ROR_GET_ALL_USERS}")
	String getAllUsers;

	@RequestMapping(value = "/getUsers", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<RORUser> getUser() throws RestClientException, URISyntaxException {
		List<RORUser> rorUser = null;
		if (getAllUsers == null) {
			return rorUser;
		}
		if (restTemplate != null) {
			rorUser = restTemplate.getForObject(new URI(getAllUsers), List.class);
			System.out.println(rorUser);
		} else {
			System.out.println("restTemplate is null");
		}
		return rorUser;
	}

}
