package com.ror.apigtyway.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ror.apigtyway.service.APIGatewayService;
import com.ror.model.RORUser;
import com.ror.vo.RORResponseVO;

@Service
public class APIGatewayServiceImpl implements APIGatewayService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${ROR_GET_ALL_USERS}")
	String getAllUsers;

	@Value("${ROR_FETCH_USER}")
	String fetchUser;

	@Value("${ROR_STORE_USER}")
	String storeUser;

	@Value("${ROR_UPDATE_USER}")
	String updateUser;

	@Value("${ROR_DELETE_USER}")
	String deleteUser;

	public List<RORUser> fetchAllUsers() {
		List<RORUser> rorUserList = null;
		try {
			rorUserList = restTemplate.getForObject(new URI(getAllUsers), List.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return rorUserList;
	}

	public RORUser fetchUser(String userId) {
		RORUser rorUser = null;
		System.out.println("user Id is " + userId);
		String finalUrl = MessageFormat.format(fetchUser, userId);
		System.out.println("The final Url for fetch User is " + finalUrl);
		try {
			rorUser = restTemplate.getForObject(new URI(finalUrl), RORUser.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return rorUser;
	}

	public RORResponseVO storeUser(RORUser rorUser) {
		RORResponseVO rorResponseVO = new RORResponseVO();
		System.out.println("Store user url is " + storeUser);
		try {
			rorResponseVO = restTemplate.postForObject(storeUser, rorUser, RORResponseVO.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return rorResponseVO;
	}

	public RORResponseVO updateUser(RORUser rorUser) {
		RORResponseVO rorResponseVO = new RORResponseVO();
		rorResponseVO.setStatusCode("200");
		rorResponseVO.setStatusMessage("User Updation Successful");
		try {
			restTemplate.put(updateUser, rorUser);
		} catch (RestClientException e) {
			rorResponseVO.setStatusCode("500");
			rorResponseVO.setStatusMessage("User Updation Failed" + e.getMessage());
			e.printStackTrace();
		}
		return rorResponseVO;
	}

	public RORResponseVO deleteUser(String userId) {
		RORResponseVO rorResponseVO = getRORResponseVO("200", "User Deletion Successful");
		String finalDeleteUser = MessageFormat.format(deleteUser, userId);
		try {
			restTemplate.delete(finalDeleteUser);
		} catch (RestClientException e) {
			rorResponseVO = getRORResponseVO("500", "User Deletion Failed" + e.getMessage());
			e.printStackTrace();
		}
		return rorResponseVO;
	}
}
