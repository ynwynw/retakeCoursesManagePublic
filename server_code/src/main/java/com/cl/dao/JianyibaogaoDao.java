package com.cl.dao;

import com.cl.entity.JianyibaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JianyibaogaoView;


/**
 * 建议报告
 * 
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
public interface JianyibaogaoDao extends BaseMapper<JianyibaogaoEntity> {
	
	List<JianyibaogaoView> selectListView(@Param("ew") Wrapper<JianyibaogaoEntity> wrapper);

	List<JianyibaogaoView> selectListView(Pagination page,@Param("ew") Wrapper<JianyibaogaoEntity> wrapper);
	
	JianyibaogaoView selectView(@Param("ew") Wrapper<JianyibaogaoEntity> wrapper);


}
