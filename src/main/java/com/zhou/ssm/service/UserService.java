package com.zhou.ssm.service;

import com.zhou.ssm.entity.User;

public interface UserService {
	
	/**
     * 通过用户名查询用户信息
     * @param username
     * @return
     */
    User getUserByName(String username);
    
    /**
     * 更新用户信息
     * @param blogger
     * @return
     */
    Integer updateUser(User user);
}
