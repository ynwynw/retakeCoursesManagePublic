package com.cl.dao;

import com.cl.entity.ZhuanyeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhuanyeView;


/**
 * 专业
 * 
 * @author 
 * @email 
 * @date 2024-11-09 21:00:49
 */
public interface ZhuanyeDao extends BaseMapper<ZhuanyeEntity> {
	
	List<ZhuanyeView> selectListView(@Param("ew") Wrapper<ZhuanyeEntity> wrapper);

	List<ZhuanyeView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuanyeEntity> wrapper);
	
	ZhuanyeView selectView(@Param("ew") Wrapper<ZhuanyeEntity> wrapper);


}
