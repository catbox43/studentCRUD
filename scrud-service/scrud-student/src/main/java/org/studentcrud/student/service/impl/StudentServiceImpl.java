package org.studentcrud.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.studentcrud.student.entity.ScrudStudent;
import org.studentcrud.student.mapper.ScrudStudentMapper;
import org.studentcrud.student.service.IStudentService;

@Service
public class StudentServiceImpl extends ServiceImpl<ScrudStudentMapper, ScrudStudent> implements IStudentService {
}
