package org.studentcrud.grader.feign;

import org.springblade.core.tool.api.R;
import org.springframework.stereotype.Component;
import org.studentcrud.grader.entity.ScrudGrader;

/**
 * Feign失败配置
 */
@Component
public class IGraderClientFallback implements IGraderClient{

    @Override
    public R<ScrudGrader> getById(Integer graderId) {
        return R.fail("获取班级失败");
    }
}
