package com.cl.dao;

import com.cl.entity.ShenqingfuheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenqingfuheView;


/**
 * 申请复核
 * 
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
public interface ShenqingfuheDao extends BaseMapper<ShenqingfuheEntity> {
	
	List<ShenqingfuheView> selectListView(@Param("ew") Wrapper<ShenqingfuheEntity> wrapper);

	List<ShenqingfuheView> selectListView(Pagination page,@Param("ew") Wrapper<ShenqingfuheEntity> wrapper);
	
	ShenqingfuheView selectView(@Param("ew") Wrapper<ShenqingfuheEntity> wrapper);


    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShenqingfuheEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShenqingfuheEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShenqingfuheEntity> wrapper);



}
