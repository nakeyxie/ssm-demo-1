package com.zhou.ssm.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.zhou.ssm.entity.User;
import com.zhou.ssm.service.UserService;

/**
 * @Description 自定义realm
 */
public class MyRealm extends AuthorizingRealm{

    @Resource
    private UserService userService;

    /**
     * 为当前登陆的用户授予角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //因为我们是个人用户 所以不存在角色权限
        return null;
    }

    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal(); //获取用户名
        User user = userService.getUserByName(username);   //重数据库查询用户信息
        if (user!= null) {
            SecurityUtils.getSubject().getSession().setAttribute("currentUser", user);//把当前用户存到session中
          //将正确的用户信息，请求登录用户的用户名和正确的密码，创建AuthenticationInfo对象并返回  
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
                    user.getUsername(), user.getPassword(), "MyRealm");
            return authcInfo;
        } else {
            return null;
        }
    }
}
