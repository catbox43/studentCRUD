package org.studentcrud.grader.wrapper;

import org.springblade.core.mp.support.BaseEntityWrapper;
import org.springblade.core.tool.utils.BeanUtil;
import org.studentcrud.grader.entity.ScrudGrader;
import org.studentcrud.grader.vo.GraderVO;

/**
 * 包装类,返回视图层所需的字段
 */
public class GraderWrapper extends BaseEntityWrapper<ScrudGrader, GraderVO> {


	public static GraderWrapper build() {
		return new GraderWrapper();
	}

	@Override
	public GraderVO entityVO(ScrudGrader grader) {
		GraderVO raderVO = BeanUtil.copy(grader, GraderVO.class);
		return raderVO;
	}

}
