package com.yhc.demo2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yhc.util.SSOCheck;

public class Demo2Action extends ActionSupport {

	//登录请求地址
	private String gotoUrl;
	
	public String main(){
		// 校验cookie有效性
		HttpServletRequest req = ServletActionContext.getRequest();
		if(SSOCheck.checkCookie(req)){
			return SUCCESS;
		}
		gotoUrl = "/demo2/main.action";
		return LOGIN;
	}

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}
	
	
}
