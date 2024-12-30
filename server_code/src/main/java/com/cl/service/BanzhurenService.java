package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BanzhurenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BanzhurenView;


/**
 * 班主任
 *
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
public interface BanzhurenService extends IService<BanzhurenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BanzhurenView> selectListView(Wrapper<BanzhurenEntity> wrapper);
   	
   	BanzhurenView selectView(@Param("ew") Wrapper<BanzhurenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BanzhurenEntity> wrapper);
   	
   
}

