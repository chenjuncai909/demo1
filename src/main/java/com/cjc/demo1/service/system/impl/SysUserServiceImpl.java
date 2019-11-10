package com.cjc.demo1.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjc.demo1.entity.system.SysUser;
import com.cjc.demo1.dao.system.SysUserMapper;
import com.cjc.demo1.enums.ErrorCodeAndMsg;
import com.cjc.demo1.exception.UserException;
import com.cjc.demo1.service.system.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjc
 * @since 2019-10-29
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public SysUser findByUserName(String username) {
        if(null == username||"".equals(username))
        {
            throw new UserException(ErrorCodeAndMsg.User_name_is_empty);
        }
        QueryWrapper<SysUser> uq = new QueryWrapper<>();
        uq.eq("username",username);
        return this.baseMapper.selectOne(uq);
    }
}
