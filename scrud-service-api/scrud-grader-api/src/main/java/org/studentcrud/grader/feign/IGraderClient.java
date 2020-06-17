package org.studentcrud.grader.feign;

import org.springblade.core.tool.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.studentcrud.common.constant.ApplicationConstant;
import org.studentcrud.grader.entity.ScrudGrader;


@FeignClient(
        value = ApplicationConstant.APPLICATION_GRADER_NAME,
        fallback = IGraderClientFallback.class
)
public interface IGraderClient {

    String API_PREFIX = "/grader";

    /**
     * 根据ID获取班级
     * @param graderId
     * @return
     */
    @GetMapping(API_PREFIX+"/get-by-id")
    R<ScrudGrader> getById(@RequestParam Integer graderId);

}
