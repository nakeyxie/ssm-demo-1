package com.zhou.ssm.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @Description 用户信息实体类
 */
@Component  //注册bean 为spring容器管理
public class User implements Serializable {

    private Integer id;
    private String username;    //用户名
    private String password;    //密码
    private String imagename;   //用户头像

    public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	public User(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
