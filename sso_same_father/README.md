## SSO登录 同父域SSO

不同服务器，域名的父域相同  

- 同父域SSO  
http://demo1.x.com/demo1/main.action   
http://demo2.x.com/demo2/main.action   


> 统一校验接口  .x.com为父域
http://check.x.com/sso/checkCookie.action 

> 正常情况下 三个链接分别存在三个服务器上  
模拟此情况：  
tomcat配置: `<Context path="" debug="0" docBase="G:\java_web\sso_same_father\WebContent" reloadable="false"/>`  
Host配置:  
127.0.0.1 demo1.x.com  
127.0.0.1 demo2.x.com  
127.0.0.1 check.x.com  