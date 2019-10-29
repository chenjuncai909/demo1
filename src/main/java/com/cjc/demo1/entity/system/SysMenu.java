package com.cjc.demo1.entity.system;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author cjc
 * @since 2019-10-29
 */
@Data
@Accessors(chain = true)
public class SysMenu   {

    private static final long serialVersionUID = 1L;
    /**
     * 菜单Id
     */
    @TableId("id")
    private String id;
    /**
     * 菜单名
     */
    private String name;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否显示
     */
    private Integer state;

    /**
     * 路径
     */
    private String url;

    /**
     * 父菜单Id
     */
    private String pid;


}
