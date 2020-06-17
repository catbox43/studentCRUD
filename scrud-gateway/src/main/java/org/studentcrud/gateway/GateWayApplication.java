package org.studentcrud.gateway;

import org.springblade.core.launch.BladeApplication;
import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableHystrix
@EnableScheduling
@SpringCloudApplication
public class GateWayApplication {

    public static void main(String[] args) {
        BladeApplication.run(AppConstant.APPLICATION_GATEWAY_NAME, GateWayApplication.class, args);
    }

}
