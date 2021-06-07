package com.user.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.user.entities.User;

@Service
public class UserServiceImpl implements UserService {
	
	List<User> userList = List.of(
							new User(100L, "Peter Lynch", "12345"),
							new User(200L, "Sumit Sharma", "67890"),
							new User(300L, "Dawid Malan", "67890")
						);

	@Override
	public User getUser(Long id) {
		return this.userList.stream()
				   .filter( user -> user.getUserId().equals(id))
				   .findAny()
				   .orElse(null);
	}

}
