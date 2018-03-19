package com.izba.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Transactional
	public List<User> getUsers(long id) {
		return userDao.listUsers(id);
	}

	@Transactional
	public User getUser(long id) {
		return userDao.getUser(id);
	}

	@Transactional
	public User addUser(User user) {
		return userDao.addUser(user);
	}

	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Transactional
	public void deleteUser(long id) {
		userDao.deleteUser(id);
	}
}
