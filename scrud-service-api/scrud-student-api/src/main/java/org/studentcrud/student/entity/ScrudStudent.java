package org.studentcrud.student.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * scrud_student
 * @author 
 */
@Data
public class ScrudStudent implements Serializable {
    /**
     * 学生ID
     */
    @TableId(value = "stu_id", type = IdType.AUTO)
    private Integer stuId;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 学生性别
     */
    private Boolean stuGender;

    /**
     * 班级ID
     */
    private Integer graderId;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}