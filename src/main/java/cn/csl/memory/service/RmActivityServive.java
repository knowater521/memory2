package cn.csl.memory.service;

import cn.csl.basics.dao.BasicsAdminMapper;
import cn.csl.basics.model.ResultResponse;
import cn.csl.basics.service.BasicsService;
import cn.csl.memory.dao.RmActivityMapper;
import cn.csl.memory.entity.RmRoot;
import cn.csl.memory.entity.RmActivity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RmActivityServive extends BasicsService<RmActivity> {
	@Resource
	private RmActivityMapper rmActivityMapper;

	@Override
	public BasicsAdminMapper<RmActivity> getBasicsAdminMapper(){return rmActivityMapper;}

	@Override
	public ResultResponse editSave(RmActivity activity){
		ResultResponse resultResponse;
		resultResponse = checkInfo(activity);
		if (resultResponse.isError()) {
			return resultResponse;
		}

		RmActivity dbActivity = getBasicsAdminMapper().selectByPrimaryKey(activity.getId());
		dbActivity.setEndTime(activity.getEndTime());
		dbActivity.setStartTime(activity.getStartTime());
		dbActivity.setVocNumber(activity.getVocNumber());
		getBasicsAdminMapper().updateByPrimaryKey(dbActivity);
		resultResponse.setSuccessResult("修改成功");
		return resultResponse;
	}
}
