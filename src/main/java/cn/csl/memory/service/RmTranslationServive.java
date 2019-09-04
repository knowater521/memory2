package cn.csl.memory.service;

import cn.csl.basics.dao.BasicsAdminMapper;
import cn.csl.basics.model.ResultResponse;
import cn.csl.basics.service.BasicsService;
import cn.csl.memory.dao.RmPlanMapper;
import cn.csl.memory.dao.RmTranslationMapper;
import cn.csl.memory.entity.RmPlan;
import cn.csl.memory.entity.RmTranslation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RmTranslationServive extends BasicsService<RmTranslation> {
	@Resource
	private RmTranslationMapper rmTranslationMapper;

	@Override
	public BasicsAdminMapper<RmTranslation> getBasicsAdminMapper(){return rmTranslationMapper;}

	@Override
	public ResultResponse editSave(RmTranslation translation){
		ResultResponse resultResponse;
		resultResponse = checkInfo(translation);
		if (resultResponse.isError()) {
			return resultResponse;
		}

		RmTranslation dbRmTranslation = getBasicsAdminMapper().selectByPrimaryKey(translation.getId());
		dbRmTranslation.setContent(translation.getContent());
		dbRmTranslation.setVocNumber(translation.getVocNumber());
		getBasicsAdminMapper().updateByPrimaryKey(dbRmTranslation);
		resultResponse.setSuccessResult("修改成功");
		return resultResponse;
	}
}
