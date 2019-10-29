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
public class SysRole   {

    private static final long serialVersionUID = 1L;
    /**
     * 角色Id
     */
    @TableId("id")
    private String id;
    /**
     * 角色名
     */
    private String name;

    /**
     * 备注
     */
    private String remarks;


}
