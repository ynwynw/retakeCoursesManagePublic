package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhongxiukechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhongxiukechengView;


/**
 * 重修课程
 *
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
public interface ZhongxiukechengService extends IService<ZhongxiukechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhongxiukechengView> selectListView(Wrapper<ZhongxiukechengEntity> wrapper);
   	
   	ZhongxiukechengView selectView(@Param("ew") Wrapper<ZhongxiukechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhongxiukechengEntity> wrapper);
   	
   
    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ZhongxiukechengEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ZhongxiukechengEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ZhongxiukechengEntity> wrapper);



}

