package org.studentcrud.grader.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.studentcrud.grader.entity.ScrudGrader;

@Data
@EqualsAndHashCode(callSuper = true)
public class GraderVO extends ScrudGrader {

    /**
     * 班级ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
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
