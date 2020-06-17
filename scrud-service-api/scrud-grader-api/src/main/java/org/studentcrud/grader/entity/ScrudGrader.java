package org.studentcrud.grader.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springblade.core.mp.base.TenantEntity;

/**
 * scrud_grader
 * @author Super
 */
@Data
public class ScrudGrader implements Serializable {
    /**
     * 班级ID
     */
    @TableId(value = "grader_id", type = IdType.AUTO)
    private Integer graderId;

    /**
     * 班级名
     */
    private String graderName;

    /**
     * 班级描述
     */
    private String graderDescribe;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}