package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhongxiushenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhongxiushenqingView;


/**
 * 重修申请
 *
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
public interface ZhongxiushenqingService extends IService<ZhongxiushenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhongxiushenqingView> selectListView(Wrapper<ZhongxiushenqingEntity> wrapper);
   	
   	ZhongxiushenqingView selectView(@Param("ew") Wrapper<ZhongxiushenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhongxiushenqingEntity> wrapper);
   	
   
}

