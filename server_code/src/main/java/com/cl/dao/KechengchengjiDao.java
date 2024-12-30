package com.cl.dao;

import com.cl.entity.KechengchengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengchengjiView;


/**
 * 课程成绩
 * 
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
public interface KechengchengjiDao extends BaseMapper<KechengchengjiEntity> {
	
	List<KechengchengjiView> selectListView(@Param("ew") Wrapper<KechengchengjiEntity> wrapper);

	List<KechengchengjiView> selectListView(Pagination page,@Param("ew") Wrapper<KechengchengjiEntity> wrapper);
	
	KechengchengjiView selectView(@Param("ew") Wrapper<KechengchengjiEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KechengchengjiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KechengchengjiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KechengchengjiEntity> wrapper);

    List<Map<String, Object>> kechengmingchengkechengchengjiSectionStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KechengchengjiEntity> wrapper);


}
