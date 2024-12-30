package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KechengchengjiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengchengjiView;


/**
 * 课程成绩
 *
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
public interface KechengchengjiService extends IService<KechengchengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengchengjiView> selectListView(Wrapper<KechengchengjiEntity> wrapper);
   	
   	KechengchengjiView selectView(@Param("ew") Wrapper<KechengchengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengchengjiEntity> wrapper);
   	
   
    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<KechengchengjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<KechengchengjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<KechengchengjiEntity> wrapper);

    List<Map<String, Object>> kechengmingchengkechengchengjiSectionStat(Map<String, Object> params,Wrapper<KechengchengjiEntity> wrapper);


}

