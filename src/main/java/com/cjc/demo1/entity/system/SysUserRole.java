package com.cjc.demo1.entity.system;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode()
@Accessors(chain = true)
public class SysUserRole  {

    private static final long serialVersionUID = 1L;
    /**
     * 用户角色Id
     */
    @TableId("id")
    private String id;
    /**
     * 用户Id
     */
    private String userId;

    /**
     * 角色Id
     */
    private String roleId;


}
