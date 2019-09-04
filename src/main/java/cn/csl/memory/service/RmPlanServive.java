package cn.csl.memory.service;

import cn.csl.basics.dao.BasicsAdminMapper;
import cn.csl.basics.model.ResultResponse;
import cn.csl.basics.service.BasicsService;
import cn.csl.memory.dao.RmActivityMapper;
import cn.csl.memory.dao.RmPlanMapper;
import cn.csl.memory.entity.RmActivity;
import cn.csl.memory.entity.RmPlan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RmPlanServive extends BasicsService<RmPlan> {
	@Resource
	private RmPlanMapper rmPlanMapper;

	@Override
	public BasicsAdminMapper<RmPlan> getBasicsAdminMapper(){return rmPlanMapper;}

	@Override
	public ResultResponse editSave(RmPlan plan){
		ResultResponse resultResponse;
		resultResponse = checkInfo(plan);
		if (resultResponse.isError()) {
			return resultResponse;
		}

		RmPlan dbRmPlan = getBasicsAdminMapper().selectByPrimaryKey(plan.getId());
		dbRmPlan.setVocabularyId(plan.getVocabularyId());
		dbRmPlan.setVocNumber(plan.getVocNumber());
		getBasicsAdminMapper().updateByPrimaryKey(dbRmPlan);
		resultResponse.setSuccessResult("修改成功");
		return resultResponse;
	}
}
