package org.studentcrud.grader.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.constant.BladeConstant;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import org.studentcrud.grader.entity.ScrudGrader;
import org.studentcrud.grader.service.IGraderService;
import org.studentcrud.grader.vo.GraderVO;
import org.studentcrud.grader.wrapper.GraderWrapper;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class GraderController {

    private IGraderService service;

    /**
     * 添加班级
     * @param grader
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody ScrudGrader grader){
        return R.status(service.save(grader));
    }

    /**
     * 修改班级
     * @param grader
     * @return
     */
    @PostMapping("update")
    public R update(@RequestBody ScrudGrader grader){
        return R.status(service.updateById(grader));
    }

    /**
     * 通过ID获取班级
     * @param id
     * @return
     */
    @GetMapping("detail")
    public R detail(Integer id){
        return R.data(GraderWrapper.build().entityVO(service.getById(id)));
    }

    /**
     * 获取所有班级
     * @return
     */
    @GetMapping("list")
    public R<IPage<GraderVO>> list(@RequestParam(defaultValue = "") String graderName, Query query){
        QueryWrapper<ScrudGrader> queryWrapper = Condition.getQueryWrapper(null);
        if(!graderName.isEmpty()){
            queryWrapper.like("grader_name",graderName);
        }
        IPage<ScrudGrader> pages = service.page(Condition.getPage(query), queryWrapper);
        return R.data(GraderWrapper.build().pageVO(pages));
    }

    /**
     * 通过ID删除班级
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
