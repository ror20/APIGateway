package com.ror.apigtyway.service;

import java.util.List;

import com.ror.model.RORUser;
import com.ror.vo.RORResponseVO;

public interface APIGatewayService {
	List<RORUser> fetchAllUsers();

	RORUser fetchUser(String userId);

	RORResponseVO storeUser(RORUser rorUser);

	RORResponseVO updateUser(RORUser rorUser);

	RORResponseVO deleteUser(String userId);

	default RORResponseVO getRORResponseVO(String code, String meString) {
		RORResponseVO rorResponseVO = new RORResponseVO();
		rorResponseVO.setStatusCode(code);
		rorResponseVO.setStatusMessage(meString);
		return rorResponseVO;
	}

}
