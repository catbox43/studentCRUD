package org.studentcrud.grader;

import org.mybatis.spring.annotation.MapperScan;
import org.springblade.core.launch.BladeApplication;
import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.studentcrud.common.constant.ApplicationConstant;

/**
 * 班级启动器
 */

@SpringCloudApplication
@EnableFeignClients(ApplicationConstant.BASE_PACKAGES)
@MapperScan("org.studentcrud.grader.mapper")
public class GraderApplication {
    public static void main(String[] args) {
        BladeApplication.run(ApplicationConstant.APPLICATION_GRADER_NAME,GraderApplication.class,args);
    }
}
