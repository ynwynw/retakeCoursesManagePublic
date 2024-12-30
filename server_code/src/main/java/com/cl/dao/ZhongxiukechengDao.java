package com.cl.dao;

import com.cl.entity.ZhongxiukechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhongxiukechengView;


/**
 * 重修课程
 * 
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
public interface ZhongxiukechengDao extends BaseMapper<ZhongxiukechengEntity> {
	
	List<ZhongxiukechengView> selectListView(@Param("ew") Wrapper<ZhongxiukechengEntity> wrapper);

	List<ZhongxiukechengView> selectListView(Pagination page,@Param("ew") Wrapper<ZhongxiukechengEntity> wrapper);
	
	ZhongxiukechengView selectView(@Param("ew") Wrapper<ZhongxiukechengEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhongxiukechengEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhongxiukechengEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhongxiukechengEntity> wrapper);



}
