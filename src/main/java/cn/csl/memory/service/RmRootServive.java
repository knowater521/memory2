package cn.csl.memory.service;

import cn.csl.basics.dao.BasicsAdminMapper;
import cn.csl.basics.model.ResultResponse;
import cn.csl.basics.service.BasicsService;
import cn.csl.memory.dao.RmRootMapper;
import cn.csl.memory.entity.RmRoot;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RmRootServive extends BasicsService<RmRoot> {
	@Resource
	private RmRootMapper rmRootMapper;

	@Override
	public BasicsAdminMapper<RmRoot> getBasicsAdminMapper(){return rmRootMapper;}

	@Override
	public ResultResponse editSave(RmRoot root){
		ResultResponse resultResponse;
		resultResponse = checkInfo(root);
		if (resultResponse.isError()) {
			return resultResponse;
		}

		RmRoot dbRmRoot = getBasicsAdminMapper().selectByPrimaryKey(root.getId());
		dbRmRoot.setContent(root.getContent());
		dbRmRoot.setExampleVocabulary(root.getExampleVocabulary());
		dbRmRoot.setExampleVocabularyTranslation(root.getExampleVocabularyTranslation());
		dbRmRoot.setImgUrl(root.getImgUrl());
		getBasicsAdminMapper().updateByPrimaryKey(dbRmRoot);
		resultResponse.setSuccessResult("修改成功");
		return resultResponse;
	}
}
