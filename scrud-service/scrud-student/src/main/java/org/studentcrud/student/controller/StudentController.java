package org.studentcrud.student.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import org.studentcrud.grader.entity.ScrudGrader;
import org.studentcrud.student.entity.ScrudStudent;
import org.studentcrud.student.service.IStudentService;
import org.studentcrud.student.vo.StudentVO;
import org.studentcrud.student.wrapper.StudentWrapper;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class StudentController {

    private IStudentService service;

    /**
     * 添加学生
     * @param student
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody ScrudStudent student){
        return R.status(service.save(student));
    }

    /**
     * 修改学生
     * @param student
     * @return
     */
    @PostMapping("update")
    public R update(@RequestBody ScrudStudent student){
        return R.status(service.updateById(student));
    }

    /**
     * 通过ID获取学生
     * @param id
     * @return
     */
    @GetMapping("detail")
    public R detail(Integer id){
        ScrudStudent student = service.getById(id);
        return R.data(StudentWrapper.build().entityVO(student));
    }

    /**
     * 获取所有学生
     * @return
     */
    @GetMapping("list")
    public R<IPage<StudentVO>> list(@RequestParam(defaultValue = "") String stuName, Query query){
        QueryWrapper<ScrudStudent> queryWrapper = Condition.getQueryWrapper(null);
        if(!stuName.isEmpty()){
            queryWrapper.like("stu_name",stuName);
        }
        IPage<ScrudStudent> pages = service.page(Condition.getPage(query), queryWrapper);
        return R.data(StudentWrapper.build().pageVO(pages));
    }

    /**
     * 通过ID删除学生
     * @param ids
     * @return
     */
    @PostMapping("remove")
    public R remove(@RequestBody Map<String,List> ids){
        if (Func.isNotEmpty(ids) && ids.containsKey("key")){
            return R.status(service.removeByIds(ids.get("key")));
        }
        return R.status(false);
    }

}
