package com.cjc.demo1.authentication;

/**
 * JwtToken:实现shiro的AuthenticationToken接口的类JwtToken
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/12
 */
public class JwtToken  {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }


    public Object getPrincipal() {
        return token;
    }


    public Object getCredentials() {
        return token;
    }
}

