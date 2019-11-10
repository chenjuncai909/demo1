package com.cjc.demo1.config;

/**
 * ShiroConfig:shiro 配置类,配置哪些拦截,哪些不拦截,哪些授权等等各种配置都在这里
 *
 * 很多都是老套路,按照这个套路配置就行了
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/12
 */

//@Configuration
public class ShiroConfig {
   /* // 配置自定义Realm
    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(credentialsMatcher()); //配置使用哈希密码匹配
        return userRealm;
    }

    // 配置url过滤器
    //@Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

        chainDefinition.addPathDefinition("/captcha", "anon");
        chainDefinition.addPathDefinition("/logout","anon");
        chainDefinition.addPathDefinition("/layuiadmin/**", "anon");
        chainDefinition.addPathDefinition("/druid/**", "anon");
        chainDefinition.addPathDefinition("/api/**", "anon");
        // all other paths require a logged in user
        chainDefinition.addPathDefinition("/login","anon");
        chainDefinition.addPathDefinition("/**", "authc");
        return chainDefinition;
    }

    // 设置用于匹配密码的CredentialsMatcher
    //@Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);  // 散列算法，这里使用更安全的sha256算法
        credentialsMatcher.setStoredCredentialsHexEncoded(false);  // 数据库存储的密码字段使用HEX还是BASE64方式加密
        credentialsMatcher.setHashIterations(1024);  // 散列迭代次数
        return credentialsMatcher;
    }

    // 配置security并设置userReaml，避免xxxx required a bean named 'authorizer' that could not be found.的报错
    //@Bean
    public SessionsSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }*/

}
