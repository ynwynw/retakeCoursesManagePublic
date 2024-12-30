package com.cl.dao;

import com.cl.entity.ZhongxiushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhongxiushenqingView;


/**
 * 重修申请
 * 
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
public interface ZhongxiushenqingDao extends BaseMapper<ZhongxiushenqingEntity> {
	
	List<ZhongxiushenqingView> selectListView(@Param("ew") Wrapper<ZhongxiushenqingEntity> wrapper);

	List<ZhongxiushenqingView> selectListView(Pagination page,@Param("ew") Wrapper<ZhongxiushenqingEntity> wrapper);
	
	ZhongxiushenqingView selectView(@Param("ew") Wrapper<ZhongxiushenqingEntity> wrapper);


}
