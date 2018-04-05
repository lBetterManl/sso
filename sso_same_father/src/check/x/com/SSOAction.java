package check.x.com;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import check.x.com.util.SSOCheck;

public class SSOAction extends ActionSupport {

	private String username;
	private String password;	
	private String gotoUrl;
	
	private String cookieName;
	private String cookieValue;
	
	public String doLogin(){
		boolean ok = SSOCheck.checkLogin(username, password);
		// 存储cookie
		if(ok){
			Cookie cookie = new Cookie("ssocookie", "sso");
			cookie.setDomain(".x.com");//设置父域
			cookie.setPath("/");//当前域名下所有网站可见
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.addCookie(cookie);//将cookie加到返回值的浏览器里面
			return SUCCESS;			
		}
		return null;
	}
	
	public void checkCookie() throws IOException{
		boolean ok = SSOCheck.checkCookie(cookieName, cookieValue);
		String result = "0";
		if(ok){
			result="1";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().println(result);
		response.getWriter().close();
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

	public String getCookieName() {
		return cookieName;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

	public String getCookieValue() {
		return cookieValue;
	}

	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}
	
	
}
