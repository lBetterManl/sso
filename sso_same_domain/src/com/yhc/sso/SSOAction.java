package com.yhc.sso;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yhc.util.SSOCheck;

public class SSOAction extends ActionSupport {

	private String username;
	private String password;
	
	private String gotoUrl;
	
	public String doLogin(){
		boolean ok = SSOCheck.checkLogin(username, password);
		// 存储cookie
		if(ok){
			Cookie cookie = new Cookie("ssocookie", "sso");
			cookie.setPath("/");//当前域名下所有网站可见
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.addCookie(cookie);//将cookie加到返回值的浏览器里面
			return SUCCESS;		
		}
		return null;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}
	
	
}
