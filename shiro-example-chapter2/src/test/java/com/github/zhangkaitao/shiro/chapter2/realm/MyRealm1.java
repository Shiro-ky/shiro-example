package com.github.zhangkaitao.shiro.chapter2.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * ClassName: MyRealm1 <br/>
 * Function: 自定义Realm实现. <br/>
 * Date: 2017年2月20日 上午11:11:42 <br/>
 *
 * @author kaiyun@zillionfortune.com
 * @version 
 * @since JDK 1.7
 */
public class MyRealm1 implements Realm {

	/*
	 * 返回一个唯一的Realm名字
	 */
    @Override
    public String getName() {
        return "myrealm1";
    }

    /*
     * 判断此Realm是否支持此Token
     */
    @Override
    public boolean supports(AuthenticationToken token) {
    	//仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken; 
    }

    /*
     * 根据Token获取认证信息
     */
    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

    	//得到用户名
        String username = (String)token.getPrincipal();  
        //得到密码
        String password = new String((char[])token.getCredentials()); 
        if(!"zhang".equals(username)) {//如果用户名错误
            throw new UnknownAccountException(); 
        }
        if(!"123".equals(password)) {//如果密码错误
            throw new IncorrectCredentialsException(); 
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
