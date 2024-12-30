package com.cl.dao;

import com.cl.entity.BanzhurenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BanzhurenView;


/**
 * 班主任
 * 
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
public interface BanzhurenDao extends BaseMapper<BanzhurenEntity> {
	
	List<BanzhurenView> selectListView(@Param("ew") Wrapper<BanzhurenEntity> wrapper);

	List<BanzhurenView> selectListView(Pagination page,@Param("ew") Wrapper<BanzhurenEntity> wrapper);
	
	BanzhurenView selectView(@Param("ew") Wrapper<BanzhurenEntity> wrapper);


}
