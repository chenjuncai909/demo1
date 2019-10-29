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
public class SysRoleMenu   {

    private static final long serialVersionUID = 1L;
    /**
     * 角色菜单Id
     */
    @TableId("id")
    private String id;
    /**
     * 角色Id
     */
    private String roleId;

    /**
     * 菜单Id
     */
    private String menuId;


}
