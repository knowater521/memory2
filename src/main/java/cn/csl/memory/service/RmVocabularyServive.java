package cn.csl.memory.service;

import cn.csl.basics.dao.BasicsAdminMapper;
import cn.csl.basics.model.ResultResponse;
import cn.csl.basics.service.BasicsService;
import cn.csl.memory.dao.RmVocabularyActivityMapper;
import cn.csl.memory.dao.RmVocabularyMapper;
import cn.csl.memory.entity.RmVocabulary;
import cn.csl.memory.entity.RmVocabularyActivity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RmVocabularyServive extends BasicsService<RmVocabulary> {
	@Resource
	private RmVocabularyMapper rmVocabularyMapper;

	@Override
	public BasicsAdminMapper<RmVocabulary> getBasicsAdminMapper(){return rmVocabularyMapper;}

	@Override
	public ResultResponse editSave(RmVocabulary vocabulary){
		ResultResponse resultResponse;
		resultResponse = checkInfo(vocabulary);
		if (resultResponse.isError()) {
			return resultResponse;
		}

		RmVocabulary dbRmRmVocabulary= getBasicsAdminMapper().selectByPrimaryKey(vocabulary.getId());
		dbRmRmVocabulary.setContent(vocabulary.getContent());
		dbRmRmVocabulary.setErrorNum(vocabulary.getErrorNum());
		dbRmRmVocabulary.setExampleSentence(vocabulary.getExampleSentence());
		dbRmRmVocabulary.setExampleSentenceTranslation(vocabulary.getExampleSentenceTranslation());
		dbRmRmVocabulary.setImgUrl(vocabulary.getImgUrl());
		dbRmRmVocabulary.setMemoryDate(vocabulary.getMemoryDate());
		dbRmRmVocabulary.setMemoryFlag(vocabulary.getMemoryFlag());
		dbRmRmVocabulary.setPhonogram(vocabulary.getPhonogram());
		dbRmRmVocabulary.setReviewNum(vocabulary.getReviewNum());
		dbRmRmVocabulary.setRootTranslation(vocabulary.getRootTranslation());
		getBasicsAdminMapper().updateByPrimaryKey(dbRmRmVocabulary);
		resultResponse.setSuccessResult("修改成功");
		return resultResponse;
	}
}
