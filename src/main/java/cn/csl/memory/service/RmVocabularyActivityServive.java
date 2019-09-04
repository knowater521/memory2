package cn.csl.memory.service;

import cn.csl.basics.dao.BasicsAdminMapper;
import cn.csl.basics.model.ResultResponse;
import cn.csl.basics.service.BasicsService;
import cn.csl.memory.dao.RmVocabularyActivityMapper;
import cn.csl.memory.dao.RmVocabularyRootMapper;
import cn.csl.memory.entity.RmVocabularyActivity;
import cn.csl.memory.entity.RmVocabularyRoot;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RmVocabularyActivityServive extends BasicsService<RmVocabularyActivity> {
	@Resource
	private RmVocabularyActivityMapper rmVocabularyActivityMapper;

	@Override
	public BasicsAdminMapper<RmVocabularyActivity> getBasicsAdminMapper(){return rmVocabularyActivityMapper;}

	@Override
	public ResultResponse editSave(RmVocabularyActivity rmVocabularyActivity){
		ResultResponse resultResponse;
		resultResponse = checkInfo(rmVocabularyActivity);
		if (resultResponse.isError()) {
			return resultResponse;
		}

		RmVocabularyActivity dbRmVocabularyActivity= getBasicsAdminMapper().selectByPrimaryKey(rmVocabularyActivity.getId());
		dbRmVocabularyActivity.setActivityId(rmVocabularyActivity.getActivityId());
		dbRmVocabularyActivity.setVocabularyId(rmVocabularyActivity.getVocabularyId());
		getBasicsAdminMapper().updateByPrimaryKey(dbRmVocabularyActivity);
		resultResponse.setSuccessResult("修改成功");
		return resultResponse;
	}
}
