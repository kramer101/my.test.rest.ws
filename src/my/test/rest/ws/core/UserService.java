package my.test.rest.ws.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import my.test.rest.ws.core.domain.MyUserPOJO;

public class UserService {

	public MyUserPOJO getUser(final String id) {
	
		return produceUser(id);
	}
	
	public List<MyUserPOJO> getAllUsers() {
		List<MyUserPOJO> users = new ArrayList<MyUserPOJO>();
		
		for (int i = 0; i < 20; i++) {
			users.add(produceUser(RandomStringUtils.randomNumeric(3)));
		}
		return users;
	}
	
	
	private MyUserPOJO produceUser(final String id) {
		MyUserPOJO user = new MyUserPOJO();
		user.setId(id);
		
		String userName = getRandomString(8);
		
		String userFirstName = getRandomString(8);
		String userLastName = getRandomString(8);
		
		String displayName = userLastName + ", " + userFirstName;
		user.setDisplayName(displayName);
		user.setEmail(userFirstName + "." + userLastName +"@company.com");
		user.setUserName(userName);
		
		return user;
	}
	
	private String getRandomString(final int length) {
		return RandomStringUtils.randomAscii(length);
	}
}
