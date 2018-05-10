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
import org.springframework.web.bind.annotation.ResponseBody;
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
	public @ResponseBody List<RORUser> getUser() {
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

	@RequestMapping(value = "/fetchUser/{id}", method = RequestMethod.GET)
	public @ResponseBody RORUser fetchUser(@PathVariable("id") String userId) {
		RORUser rorUser = null;
		if (restTemplate != null) {
			fetchUser = MessageFormat.format(fetchUser, userId);
			System.out.println("The final Url for fetch User is " + fetchUser);
			try {
				rorUser = restTemplate.getForObject(new URI(fetchUser), RORUser.class);
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

	@RequestMapping(value = "/storeUser", method = RequestMethod.POST)
	public @ResponseBody RORResponseVO storeUser(@RequestBody RORUser rorUser) {
		RORResponseVO rorResponseVO = new RORResponseVO();
		rorResponseVO.setStatusCode("500");
		rorResponseVO.setStatusMessage("Internal Server Error");
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

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public void updateUser(@RequestBody RORUser rorUser) {
		if (restTemplate != null) {
			try {
				restTemplate.put(updateUser, rorUser);
			} catch (RestClientException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("restTemplate is null");
		}
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") String userId) {
		deleteUser = MessageFormat.format(deleteUser, userId);
		if (restTemplate != null) {
			try {
				restTemplate.delete(deleteUser);
			} catch (RestClientException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("restTemplate is null");
		}
	}

}
