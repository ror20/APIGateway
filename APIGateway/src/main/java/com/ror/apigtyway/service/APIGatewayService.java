package com.ror.apigtyway.service;

import java.util.List;

import com.ror.model.MessageDetails;
import com.ror.model.RORMessages;
import com.ror.model.RORUser;
import com.ror.vo.RORResponseVO;

public interface APIGatewayService {
	List<RORUser> fetchAllUsers();

	RORUser fetchUser(String userId);

	RORResponseVO storeUser(RORUser rorUser);

	RORResponseVO updateUser(RORUser rorUser);

	RORResponseVO deleteUser(String userId);

	boolean checkUserExists(String userId);

	public List<MessageDetails> receivedMessage(String id);

	public RORResponseVO draftMessage(MessageDetails messageDetails);

	public RORMessages messageCompleteDetails(String id);
	
	public List<MessageDetails> fetchConversation(String u1andu2);

	default RORResponseVO getRORResponseVO(String code, String meString) {
		RORResponseVO rorResponseVO = new RORResponseVO();
		rorResponseVO.setStatusCode(code);
		rorResponseVO.setStatusMessage(meString);
		return rorResponseVO;
	}

}
