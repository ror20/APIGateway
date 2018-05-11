package com.ror.apigtyway;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ror.model.RORUser;
import com.ror.vo.RORResponseVO;

@RestController
@RequestMapping(value = "/apiGtway/api")
public class APIAccessGtway {

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

	@RequestMapping(value = "/fetchAllUsers", produces = "application/json", method = RequestMethod.GET)
	public List<RORUser> getUser() {
		List<RORUser> rorUserList = null;
		if (getAllUsers == null) {
			return rorUserList;
		}
		if (restTemplate != null) {
			try {
				rorUserList = restTemplate.getForObject(new URI(getAllUsers), List.class);
			} catch (RestClientException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("restTemplate is null");
		}
		return rorUserList;
	}

	@RequestMapping(value = "/fetchUser/{id}", method = RequestMethod.GET, produces = "application/json")
	public RORUser fetchUser(@PathVariable("id") String userId) {
		RORUser rorUser = null;
		if (restTemplate != null) {
			System.out.println("user Id is "+userId);
			String finalUrl = MessageFormat.format(fetchUser, userId);
			System.out.println("The final Url for fetch User is " + finalUrl);
			try {
				rorUser = restTemplate.getForObject(new URI(finalUrl), RORUser.class);
			} catch (RestClientException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("restTemplate is null");
		}
		return rorUser;
	}

	@RequestMapping(value = "/storeUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public RORResponseVO storeUser(@RequestBody RORUser rorUser) {
		RORResponseVO rorResponseVO = new RORResponseVO();
		System.out.println("Store user url is " + storeUser);
		if (restTemplate != null) {
			try {
				rorResponseVO = restTemplate.postForObject(storeUser, rorUser, RORResponseVO.class);
			} catch (RestClientException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("restTemplate is null");
		}
		return rorResponseVO;
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT, consumes = "application/json",produces = "application/json")
	public RORResponseVO updateUser(@RequestBody RORUser rorUser) {
		RORResponseVO rorResponseVO = new RORResponseVO();
		rorResponseVO.setStatusCode("200");
		rorResponseVO.setStatusMessage("User Updation Successful");
		if (restTemplate != null) {
			try {
				restTemplate.put(updateUser, rorUser);
			} catch (RestClientException e) {
				rorResponseVO.setStatusCode("500");
				rorResponseVO.setStatusMessage("User Updation Failed" + e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("restTemplate is null");
		}
		return rorResponseVO;
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public RORResponseVO deleteUser(@PathVariable("id") String userId) {
		RORResponseVO rorResponseVO = new RORResponseVO();
		rorResponseVO.setStatusCode("200");
		rorResponseVO.setStatusMessage("User Deletion Successful");
		String finalDeleteUser = MessageFormat.format(deleteUser, userId);
		if (restTemplate != null) {
			try {
				restTemplate.delete(finalDeleteUser);
			} catch (RestClientException e) {
				rorResponseVO.setStatusCode("500");
				rorResponseVO.setStatusMessage("User Deletion Failed" + e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("restTemplate is null");
		}
		return rorResponseVO;
	}

}
