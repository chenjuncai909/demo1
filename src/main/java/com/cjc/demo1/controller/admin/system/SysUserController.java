package com.cjc.demo1.controller.admin.system;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjc.demo1.entity.system.SysUser;
import com.cjc.demo1.enums.ErrorCodeAndMsg;
import com.cjc.demo1.exception.UserException;
import com.cjc.demo1.service.system.ISysUserService;
import com.cjc.demo1.utils.MD5;
import com.cjc.demo1.utils.UuidUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


/**
 * <p>
 *  后台前端控制器
 * </p>
 *
 * @author cjc
 * @since 2019-10-29
 */
@RestController
@Api(tags="用户控制类")
@RequestMapping("user")
public class SysUserController  {
    @Autowired
    private ISysUserService ISysUserService;
    @RequestMapping(value="/add", method= RequestMethod.POST)
    @ApiOperation(value = "添加", notes = "用户添加", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user",value = "用户实例", required = true, paramType = "SysUser"),

    })
    public String add(SysUser user){
        if(null==user)
        {
            return "00";
        }
        else
        {
            String password = MD5.md5(user.getPassWord());
            user.setId(UuidUtil.get32UUID());
            user.setPassWord(password);
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            ISysUserService.save(user);
            return "01";
        }

    }
    @RequestMapping(value="/edit", method= RequestMethod.POST)
    @ApiOperation(value = "修改", notes = "用户修改", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user",value = "用户实例", required = true, paramType = "SysUser"),

    })
    public String update(SysUser user){
        if(null==user)
        {
            throw new UserException(ErrorCodeAndMsg.User_is_empty);
        }
        else
        {
            user.setUpdateTime(LocalDateTime.now());
            ISysUserService.updateById(user);
            return "01";
        }

    }
    @RequestMapping(value="/getById", method= RequestMethod.GET)
    @ApiOperation(value = "根据Id获取用户", notes = "根据Id获取用户", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户Id", required = true, paramType = "SysUser"),

    })
    public SysUser getById(String id){
        if(id==null){
            throw new  UserException(ErrorCodeAndMsg.User_Id_is_empty);
        }
        if(id.equals(""))
        { throw new  UserException(ErrorCodeAndMsg.User_Id_is_empty);}
        return ISysUserService.getById(id);
    }
    @RequestMapping(value="/del", method= RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "用户删除", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户Id", required = true, paramType = "SysUser"),
    })
    public String delete(String id){
        if(null==id)
        {
            throw new UserException(ErrorCodeAndMsg.User_Id_is_empty);
        }
        else
        {
            ISysUserService.removeById(id);
            return "01";
        }

    }
    @RequestMapping(value="/getByCondition", method= RequestMethod.GET)
    @ApiOperation(value = "根据情况查询并分页", notes = "根据情况查询并分页", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user",value = "用户实例", required = true, paramType = "SysUser"),
    })
    public IPage<SysUser> listByCondition(String keyWords ,Long page,Long size,String endDate,String startDate,String sortName,Integer sort){
        //设置分页参数
        Page<SysUser> sysUserPage = new Page<>();
        if(page==null){
            page = 1L;
        }
        if(size==null){
            size = 10L;
        }
        if(sortName==null||sortName.equals("")){
            sortName = "createTime";
        }
        if(null!=sort&&sort==0){
            sysUserPage.setAsc(sortName);
        }
        else{
            sysUserPage.setDesc(sortName);
        }
        sysUserPage.setCurrent(page);
        sysUserPage.setSize(size);
        //设置查询条件
        QueryWrapper<SysUser> sysUserQueryWrapper ;
        if(null==keyWords)
        {
            sysUserQueryWrapper = null;
        }
        else
        {
            sysUserQueryWrapper = new QueryWrapper<>();
            sysUserQueryWrapper.like("name",keyWords).or().like("userName",keyWords);

        }
        if(null!=endDate&&!"".equals(endDate))
        {
            assert sysUserQueryWrapper != null;
            sysUserQueryWrapper.and(i -> i.ge("createTime", endDate));
        }
        if(null!=startDate&&!"".equals(startDate))
        {
            assert sysUserQueryWrapper != null;
            sysUserQueryWrapper.and(i -> i.le("createTime", startDate));
        }
        return ISysUserService.page(sysUserPage, sysUserQueryWrapper);
    }

}
