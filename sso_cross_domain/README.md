## SSO登录 跨域SSO


cookie可以存在父域下，但是跨域就不行    

- 跨域SSO  
http://www.a.com/demo1/main.action   
http://www.b.com/demo2/main.action  

http://www.x.com/sso/doLogin.action   


> 统一校验接口  .x.com为验证域
http://www.x.com/sso/doLogin.action 

> 正常情况下 三个链接分别存在三个服务器上  
模拟此情况：  
tomcat配置: `<Context path="" debug="0" docBase="G:\java_web\sso_cross_domain\WebContent" reloadable="false"/>`  
Host配置:  
127.0.0.1 www.a.com  
127.0.0.1 www.b.com  
127.0.0.1 www.x.com  