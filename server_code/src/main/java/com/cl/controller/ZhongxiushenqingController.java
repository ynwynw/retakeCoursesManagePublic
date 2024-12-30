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

import com.cl.entity.ZhongxiushenqingEntity;
import com.cl.entity.view.ZhongxiushenqingView;

import com.cl.service.ZhongxiushenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 重修申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
@RestController
@RequestMapping("/zhongxiushenqing")
public class ZhongxiushenqingController {
    @Autowired
    private ZhongxiushenqingService zhongxiushenqingService;







    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhongxiushenqingEntity zhongxiushenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("banzhuren")) {
			zhongxiushenqing.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			zhongxiushenqing.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhongxiushenqingEntity> ew = new EntityWrapper<ZhongxiushenqingEntity>();

		PageUtils page = zhongxiushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongxiushenqing), params), params));

        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhongxiushenqingEntity zhongxiushenqing, 
		HttpServletRequest request){
        EntityWrapper<ZhongxiushenqingEntity> ew = new EntityWrapper<ZhongxiushenqingEntity>();

		PageUtils page = zhongxiushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongxiushenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhongxiushenqingEntity zhongxiushenqing){
       	EntityWrapper<ZhongxiushenqingEntity> ew = new EntityWrapper<ZhongxiushenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhongxiushenqing, "zhongxiushenqing")); 
        return R.ok().put("data", zhongxiushenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhongxiushenqingEntity zhongxiushenqing){
        EntityWrapper< ZhongxiushenqingEntity> ew = new EntityWrapper< ZhongxiushenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhongxiushenqing, "zhongxiushenqing")); 
		ZhongxiushenqingView zhongxiushenqingView =  zhongxiushenqingService.selectView(ew);
		return R.ok("查询重修申请成功").put("data", zhongxiushenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhongxiushenqingEntity zhongxiushenqing = zhongxiushenqingService.selectById(id);
		zhongxiushenqing = zhongxiushenqingService.selectView(new EntityWrapper<ZhongxiushenqingEntity>().eq("id", id));
        return R.ok().put("data", zhongxiushenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhongxiushenqingEntity zhongxiushenqing = zhongxiushenqingService.selectById(id);
		zhongxiushenqing = zhongxiushenqingService.selectView(new EntityWrapper<ZhongxiushenqingEntity>().eq("id", id));
        return R.ok().put("data", zhongxiushenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhongxiushenqingEntity zhongxiushenqing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhongxiushenqing);
        zhongxiushenqingService.insert(zhongxiushenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhongxiushenqingEntity zhongxiushenqing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhongxiushenqing);
        zhongxiushenqingService.insert(zhongxiushenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhongxiushenqingEntity zhongxiushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhongxiushenqing);
        zhongxiushenqingService.updateById(zhongxiushenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZhongxiushenqingEntity> list = new ArrayList<ZhongxiushenqingEntity>();
        for(Long id : ids) {
            ZhongxiushenqingEntity zhongxiushenqing = zhongxiushenqingService.selectById(id);
            zhongxiushenqing.setSfsh(sfsh);
            zhongxiushenqing.setShhf(shhf);
            list.add(zhongxiushenqing);
        }
        zhongxiushenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhongxiushenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
