package org.studentcrud.grader.feign;

import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.RestController;
import org.studentcrud.grader.entity.ScrudGrader;
import org.studentcrud.grader.service.IGraderService;

/**
 * 班级服务Feign实现类
 */
@RestController
@AllArgsConstructor
public class GraderClient implements IGraderClient{

    private IGraderService service;

    @Override
    public R<ScrudGrader> getById(Integer graderId) {
        return R.data(service.getById(graderId));
    }
}
