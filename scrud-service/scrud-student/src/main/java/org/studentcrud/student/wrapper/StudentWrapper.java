package org.studentcrud.student.wrapper;

import org.springblade.core.mp.support.BaseEntityWrapper;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.core.tool.utils.SpringUtil;
import org.studentcrud.grader.entity.ScrudGrader;
import org.studentcrud.grader.feign.IGraderClient;
import org.studentcrud.student.entity.ScrudStudent;
import org.studentcrud.student.service.IStudentService;
import org.studentcrud.student.vo.StudentVO;

/**
 * 包装类,返回视图层所需的字段
 */
public class StudentWrapper extends BaseEntityWrapper<ScrudStudent, StudentVO> {

	private static IStudentService studentService;

	private static IGraderClient graderClient;

	static {
		studentService = SpringUtil.getBean(IStudentService.class);
		graderClient = SpringUtil.getBean(IGraderClient.class);
	}

	public static StudentWrapper build() {
		return new StudentWrapper();
	}

	@Override
	public StudentVO entityVO(ScrudStudent student) {
		StudentVO studentVO = BeanUtil.copy(student, StudentVO.class);
		R<ScrudGrader> graderR = graderClient.getById(student.getGraderId());
		if (graderR.isSuccess()) {
			ScrudGrader grader = graderR.getData();
			studentVO.setGraderName(grader.getGraderName());
			studentVO.setGraderDescribe(grader.getGraderDescribe());
		}
		return studentVO;
	}

}
