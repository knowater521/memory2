package cn.csl.memory.service;

import cn.csl.basics.dao.BasicsAdminMapper;
import cn.csl.basics.model.ResultResponse;
import cn.csl.basics.service.BasicsService;
import cn.csl.memory.dao.RmTranslationMapper;
import cn.csl.memory.dao.RmVocabularyTranslationMapper;
import cn.csl.memory.entity.RmTranslation;
import cn.csl.memory.entity.RmVocabularyTranslation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RmVocabularyTranslationServive extends BasicsService<RmVocabularyTranslation> {
	@Resource
	private RmVocabularyTranslationMapper rmVocabularyTranslationMapper;

	@Override
	public BasicsAdminMapper<RmVocabularyTranslation> getBasicsAdminMapper(){return rmVocabularyTranslationMapper;}

	@Override
	public ResultResponse editSave(RmVocabularyTranslation vocabularyTranslation){
		ResultResponse resultResponse;
		resultResponse = checkInfo(vocabularyTranslation);
		if (resultResponse.isError()) {
			return resultResponse;
		}

		RmVocabularyTranslation dbRmVocabularyTranslation= getBasicsAdminMapper().selectByPrimaryKey(vocabularyTranslation.getId());
		dbRmVocabularyTranslation.setTranslationId(vocabularyTranslation.getTranslationId());
		dbRmVocabularyTranslation.setVocabularyId(vocabularyTranslation.getVocabularyId());
		getBasicsAdminMapper().updateByPrimaryKey(dbRmVocabularyTranslation);
		resultResponse.setSuccessResult("修改成功");
		return resultResponse;
	}
}
