package com.zhou.ssm.dao;

import org.springframework.stereotype.Repository;
 
import com.zhou.ssm.entity.User;

/**.
 * 用户dao接口
 */
@Repository //注册为持久层的bean
public interface UserDao {
    /**
     * 查询用户信息
     * @return
     */
    User getUserData();
    
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
