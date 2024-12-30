package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhuanyeEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhuanyeView;


/**
 * 专业
 *
 * @author 
 * @email 
 * @date 2024-11-09 21:00:49
 */
public interface ZhuanyeService extends IService<ZhuanyeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuanyeView> selectListView(Wrapper<ZhuanyeEntity> wrapper);
   	
   	ZhuanyeView selectView(@Param("ew") Wrapper<ZhuanyeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuanyeEntity> wrapper);
   	
   
}

