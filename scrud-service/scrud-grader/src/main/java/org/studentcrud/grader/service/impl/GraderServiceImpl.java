package org.studentcrud.grader.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.studentcrud.grader.entity.ScrudGrader;
import org.studentcrud.grader.mapper.ScrudGraderMapper;
import org.studentcrud.grader.service.IGraderService;

@Service
@AllArgsConstructor
public class GraderServiceImpl extends ServiceImpl<ScrudGraderMapper, ScrudGrader> implements IGraderService {
}
