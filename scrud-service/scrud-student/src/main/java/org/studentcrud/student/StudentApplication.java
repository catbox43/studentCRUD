package org.studentcrud.student;

import org.mybatis.spring.annotation.MapperScan;
import org.springblade.core.launch.BladeApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.studentcrud.common.constant.ApplicationConstant;

/**
 * 班级启动器
 */

@SpringCloudApplication
@EnableFeignClients(ApplicationConstant.BASE_PACKAGES)
@MapperScan("org.studentcrud.student.mapper")
public class StudentApplication {
    public static void main(String[] args) {
        BladeApplication.run(ApplicationConstant.APPLICATION_STUDENT_NAME,StudentApplication.class,args);
    }
}
