package cn.csl.memory.service;

import cn.csl.basics.dao.BasicsAdminMapper;
import cn.csl.basics.model.ResultResponse;
import cn.csl.basics.service.BasicsService;
import cn.csl.memory.dao.RmVocabularyRootMapper;
import cn.csl.memory.dao.RmVocabularyTranslationMapper;
import cn.csl.memory.entity.RmVocabularyRoot;
import cn.csl.memory.entity.RmVocabularyTranslation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RmVocabularyRootServive extends BasicsService<RmVocabularyRoot> {
	@Resource
	private RmVocabularyRootMapper rmVocabularyRootMapper;

	@Override
	public BasicsAdminMapper<RmVocabularyRoot> getBasicsAdminMapper(){return rmVocabularyRootMapper;}

	@Override
	public ResultResponse editSave(RmVocabularyRoot vocabularyRoot){
		ResultResponse resultResponse;
		resultResponse = checkInfo(vocabularyRoot);
		if (resultResponse.isError()) {
			return resultResponse;
		}

		RmVocabularyRoot dbRmVocabularyRoot= getBasicsAdminMapper().selectByPrimaryKey(vocabularyRoot.getId());
		dbRmVocabularyRoot.setRootId(vocabularyRoot.getRootId());
		dbRmVocabularyRoot.setVocabularyId(vocabularyRoot.getVocabularyId());
		getBasicsAdminMapper().updateByPrimaryKey(dbRmVocabularyRoot);
		resultResponse.setSuccessResult("修改成功");
		return resultResponse;
	}
}
