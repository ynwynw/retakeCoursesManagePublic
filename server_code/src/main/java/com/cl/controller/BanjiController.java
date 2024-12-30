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

import com.cl.entity.BanjiEntity;
import com.cl.entity.view.BanjiView;

import com.cl.service.BanjiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 班级
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-09 21:00:49
 */
@RestController
@RequestMapping("/banji")
public class BanjiController {
    @Autowired
    private BanjiService banjiService;







    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BanjiEntity banji,
		HttpServletRequest request){
        EntityWrapper<BanjiEntity> ew = new EntityWrapper<BanjiEntity>();

		PageUtils page = banjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banji), params), params));

        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BanjiEntity banji, 
		HttpServletRequest request){
        EntityWrapper<BanjiEntity> ew = new EntityWrapper<BanjiEntity>();

		PageUtils page = banjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BanjiEntity banji){
       	EntityWrapper<BanjiEntity> ew = new EntityWrapper<BanjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( banji, "banji")); 
        return R.ok().put("data", banjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BanjiEntity banji){
        EntityWrapper< BanjiEntity> ew = new EntityWrapper< BanjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( banji, "banji")); 
		BanjiView banjiView =  banjiService.selectView(ew);
		return R.ok("查询班级成功").put("data", banjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BanjiEntity banji = banjiService.selectById(id);
		banji = banjiService.selectView(new EntityWrapper<BanjiEntity>().eq("id", id));
        return R.ok().put("data", banji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BanjiEntity banji = banjiService.selectById(id);
		banji = banjiService.selectView(new EntityWrapper<BanjiEntity>().eq("id", id));
        return R.ok().put("data", banji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BanjiEntity banji, HttpServletRequest request){
        if(banjiService.selectCount(new EntityWrapper<BanjiEntity>().eq("banji", banji.getBanji()))>0) {
            return R.error("班级已存在");
        }
    	//ValidatorUtils.validateEntity(banji);
        banjiService.insert(banji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BanjiEntity banji, HttpServletRequest request){
        if(banjiService.selectCount(new EntityWrapper<BanjiEntity>().eq("banji", banji.getBanji()))>0) {
            return R.error("班级已存在");
        }
    	//ValidatorUtils.validateEntity(banji);
        banjiService.insert(banji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BanjiEntity banji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(banji);
        banjiService.updateById(banji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        banjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
