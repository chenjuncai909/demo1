package com.cjc.demo1.realm;

import com.cjc.demo1.service.system.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm  {
    @Autowired
    private ISysUserService userService;

}
