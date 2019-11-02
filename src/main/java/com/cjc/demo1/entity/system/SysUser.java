package com.cjc.demo1.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author cjc
 * @since 2019-10-29
 */
@Data
public class SysUser  {

    private static final long serialVersionUID = 1L;
    /**
     * 用户Id
     */
    @TableId("id")
    private String id;
    /**
     * 用户名
     */
    @TableField("userName")
    private String userName;

    /**
     * 密码
     */
    @TableField("passWord")
    private String passWord;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像地址
     */
    @TableField("headUrl")
    private String headUrl;

    /**
     * 注册时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("updateTime")
    private LocalDateTime updateTime;




}
