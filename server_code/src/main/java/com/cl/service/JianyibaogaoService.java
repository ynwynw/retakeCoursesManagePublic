package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JianyibaogaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianyibaogaoView;


/**
 * 建议报告
 *
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
public interface JianyibaogaoService extends IService<JianyibaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianyibaogaoView> selectListView(Wrapper<JianyibaogaoEntity> wrapper);
   	
   	JianyibaogaoView selectView(@Param("ew") Wrapper<JianyibaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianyibaogaoEntity> wrapper);
   	
   
}

