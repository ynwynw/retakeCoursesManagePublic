package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.JianyibaogaoEntity;
import com.cl.entity.view.JianyibaogaoView;

import com.cl.service.JianyibaogaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 建议报告
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
@RestController
@RequestMapping("/jianyibaogao")
public class JianyibaogaoController {
    @Autowired
    private JianyibaogaoService jianyibaogaoService;







    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianyibaogaoEntity jianyibaogao,
		HttpServletRequest request){
        EntityWrapper<JianyibaogaoEntity> ew = new EntityWrapper<JianyibaogaoEntity>();

		PageUtils page = jianyibaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianyibaogao), params), params));

        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianyibaogaoEntity jianyibaogao, 
		HttpServletRequest request){
        EntityWrapper<JianyibaogaoEntity> ew = new EntityWrapper<JianyibaogaoEntity>();

		PageUtils page = jianyibaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianyibaogao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianyibaogaoEntity jianyibaogao){
       	EntityWrapper<JianyibaogaoEntity> ew = new EntityWrapper<JianyibaogaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianyibaogao, "jianyibaogao")); 
        return R.ok().put("data", jianyibaogaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianyibaogaoEntity jianyibaogao){
        EntityWrapper< JianyibaogaoEntity> ew = new EntityWrapper< JianyibaogaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianyibaogao, "jianyibaogao")); 
		JianyibaogaoView jianyibaogaoView =  jianyibaogaoService.selectView(ew);
		return R.ok("查询建议报告成功").put("data", jianyibaogaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianyibaogaoEntity jianyibaogao = jianyibaogaoService.selectById(id);
		jianyibaogao = jianyibaogaoService.selectView(new EntityWrapper<JianyibaogaoEntity>().eq("id", id));
        return R.ok().put("data", jianyibaogao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianyibaogaoEntity jianyibaogao = jianyibaogaoService.selectById(id);
		jianyibaogao = jianyibaogaoService.selectView(new EntityWrapper<JianyibaogaoEntity>().eq("id", id));
        return R.ok().put("data", jianyibaogao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianyibaogaoEntity jianyibaogao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jianyibaogao);
        jianyibaogaoService.insert(jianyibaogao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianyibaogaoEntity jianyibaogao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jianyibaogao);
        jianyibaogaoService.insert(jianyibaogao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianyibaogaoEntity jianyibaogao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianyibaogao);
        jianyibaogaoService.updateById(jianyibaogao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianyibaogaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
