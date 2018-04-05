package www.b.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import www.a.com.util.Demo1Tool;
import www.b.com.util.Demo2Tool;

public class Demo2Action extends ActionSupport {

	//登录请求地址
	private String gotoUrl;
	
	private String username;
	private String password;
	
	private String path;
	
	private List<String> hiddenUrl;
	
	public String main(){
		// 校验cookie有效性
		HttpServletRequest req = ServletActionContext.getRequest();
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("ssocookie")){
					Map<String,String> map = new HashMap<String,String>();
					map.put("cookieName", cookie.getName());
					map.put("cookieValue", cookie.getValue());
					String result = Demo1Tool.doGet("http://www.x.com/sso/checkCookie.action"
							, map);
					if(result.equals("1")){
						return SUCCESS;
					}
				}
			}
		}
		path = "demo2";
		gotoUrl = "http://www.b.com/demo2/main.action";
		return LOGIN;
	}
	
	public String doLogin(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("username", username);
		map.put("password", password);
		String result = Demo1Tool.doGet("http://www.x.com/sso/doLogin", map);
		if(result.equals("1")){
			hiddenUrl=new ArrayList<String>();
			hiddenUrl.add("http://www.a.com/demo1/addCookie.action");
			hiddenUrl.add("http://www.b.com/demo2/addCookie.action");
			return SUCCESS;
		}
		return LOGIN;
	}
	
	public void addCookie(){
		Cookie cookie = new Cookie("ssocookie","sso");
		cookie.setPath("/");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.addCookie(cookie);
	}

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<String> getHiddenUrl() {
		return hiddenUrl;
	}

	public void setHiddenUrl(List<String> hiddenUrl) {
		this.hiddenUrl = hiddenUrl;
	}
	
	
}
