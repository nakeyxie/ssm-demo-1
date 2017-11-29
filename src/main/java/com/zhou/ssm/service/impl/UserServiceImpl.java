package com.zhou.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhou.ssm.dao.UserDao;
import com.zhou.ssm.entity.User;
import com.zhou.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;

	public User getUserByName(String username) {
		
		return userDao.getUserByName(username);
	}
	
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }
}
