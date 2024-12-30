package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShenqingfuheEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenqingfuheView;


/**
 * 申请复核
 *
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
public interface ShenqingfuheService extends IService<ShenqingfuheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenqingfuheView> selectListView(Wrapper<ShenqingfuheEntity> wrapper);
   	
   	ShenqingfuheView selectView(@Param("ew") Wrapper<ShenqingfuheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenqingfuheEntity> wrapper);
   	
   
    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShenqingfuheEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShenqingfuheEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShenqingfuheEntity> wrapper);



}

