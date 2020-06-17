package org.studentcrud.student.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.studentcrud.student.entity.ScrudStudent;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentVO extends ScrudStudent {

    /**
     * 学生ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
     * 班级名
     */
    private String graderName;

    /**
     * 班级描述
     */
    private String graderDescribe;

}
