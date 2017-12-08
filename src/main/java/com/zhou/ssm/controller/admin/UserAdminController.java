package com.zhou.ssm.controller.admin;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.zhou.ssm.entity.User;
import com.zhou.ssm.service.UserService;
import com.zhou.ssm.util.DateUtil;
import com.zhou.ssm.util.MD5Util;
import com.zhou.ssm.util.ResponseUtil;

/**
 * @Description 用户控制层前台-需要shiro认证
 */
@Controller
@RequestMapping("/user")
public class UserAdminController {
	
	@Resource
    private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request) {
        //获取登录实体
        Subject subject = SecurityUtils.getSubject();
        //获取加密后密码
        String password = MD5Util.md5(user.getPassword(), "MyRealm");
        System.out.println(password);
        //获取用户密码登录token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), password);
        try {
            //根据token登录 会调用MyRealm中的doGetAuthenticationInfo方法进行身份认证
            subject.login(token);
            return "redirect:/admin/main.jsp";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            request.setAttribute("user", user);//用于回显
            //提示信息
            request.setAttribute("errorInfo", "用户名或密码错误");
            return "admin/login";
        }
    }
	
	/**
	 * 注销
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout()throws Exception{
		SecurityUtils.getSubject().logout(); 
		return "redirect:/admin/login.jsp";
	}
	
	//更新用户密码
    @RequestMapping(value = "/modtifyPassword",method = RequestMethod.POST)
    public String modityUserPassword(User user,HttpServletResponse response) throws Exception {
        //加密
        String newPassword = MD5Util.md5(user.getPassword(),"MyRealm");
        user.setPassword(newPassword);
        int resultTotal = userService.updateUser(user);
        JSONObject result = new JSONObject();
        if(resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }
    
  //更新用户信息
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveUser(@RequestParam(value = "imageFile",required = false) MultipartFile imageFile, User user,
                              HttpServletResponse response,HttpServletRequest request) throws Exception {
        //判断是否有上图片 有就更新
        if(!imageFile.isEmpty()){
        	String filePath=request.getServletContext().getRealPath("/"); //获取服务器根路径
            String imageName = DateUtil.getCurrentDateStr() + "." + imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath + "static/userImages/" + imageName));
            user.setImagename(imageName);
        }
        int resultTotal = userService.updateUser(user);
        JSONObject result = new JSONObject();
        if(resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }

}
