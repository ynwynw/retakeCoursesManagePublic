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

import com.cl.entity.ZhongxiukechengEntity;
import com.cl.entity.view.ZhongxiukechengView;

import com.cl.service.ZhongxiukechengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;

/**
 * 重修课程
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
@RestController
@RequestMapping("/zhongxiukecheng")
public class ZhongxiukechengController {
    @Autowired
    private ZhongxiukechengService zhongxiukechengService;







    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhongxiukechengEntity zhongxiukecheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("banzhuren")) {
			zhongxiukecheng.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			zhongxiukecheng.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhongxiukechengEntity> ew = new EntityWrapper<ZhongxiukechengEntity>();

		PageUtils page = zhongxiukechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongxiukecheng), params), params));

        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhongxiukechengEntity zhongxiukecheng, 
		HttpServletRequest request){
        EntityWrapper<ZhongxiukechengEntity> ew = new EntityWrapper<ZhongxiukechengEntity>();

		PageUtils page = zhongxiukechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongxiukecheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhongxiukechengEntity zhongxiukecheng){
       	EntityWrapper<ZhongxiukechengEntity> ew = new EntityWrapper<ZhongxiukechengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhongxiukecheng, "zhongxiukecheng")); 
        return R.ok().put("data", zhongxiukechengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhongxiukechengEntity zhongxiukecheng){
        EntityWrapper< ZhongxiukechengEntity> ew = new EntityWrapper< ZhongxiukechengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhongxiukecheng, "zhongxiukecheng")); 
		ZhongxiukechengView zhongxiukechengView =  zhongxiukechengService.selectView(ew);
		return R.ok("查询重修课程成功").put("data", zhongxiukechengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhongxiukechengEntity zhongxiukecheng = zhongxiukechengService.selectById(id);
		zhongxiukecheng = zhongxiukechengService.selectView(new EntityWrapper<ZhongxiukechengEntity>().eq("id", id));
        return R.ok().put("data", zhongxiukecheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhongxiukechengEntity zhongxiukecheng = zhongxiukechengService.selectById(id);
		zhongxiukecheng = zhongxiukechengService.selectView(new EntityWrapper<ZhongxiukechengEntity>().eq("id", id));
        return R.ok().put("data", zhongxiukecheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhongxiukechengEntity zhongxiukecheng, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhongxiukecheng);
        zhongxiukechengService.insert(zhongxiukecheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhongxiukechengEntity zhongxiukecheng, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhongxiukecheng);
        zhongxiukechengService.insert(zhongxiukecheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhongxiukechengEntity zhongxiukecheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhongxiukecheng);
        zhongxiukechengService.updateById(zhongxiukecheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhongxiukechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	





    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ZhongxiukechengEntity> ew = new EntityWrapper<ZhongxiukechengEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("banzhuren")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = zhongxiukechengService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZhongxiukechengEntity> ew = new EntityWrapper<ZhongxiukechengEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("banzhuren")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zhongxiukechengService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<ZhongxiukechengEntity> ew = new EntityWrapper<ZhongxiukechengEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("banzhuren")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = zhongxiukechengService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ZhongxiukechengEntity> ew = new EntityWrapper<ZhongxiukechengEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("banzhuren")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = zhongxiukechengService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ZhongxiukechengEntity> ew = new EntityWrapper<ZhongxiukechengEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("banzhuren")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("xuesheng")) {
            ew.eq("xuehao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = zhongxiukechengService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,ZhongxiukechengEntity zhongxiukecheng, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("banzhuren")) {
            zhongxiukecheng.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("xuesheng")) {
            zhongxiukecheng.setXuehao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<ZhongxiukechengEntity> ew = new EntityWrapper<ZhongxiukechengEntity>();
        int count = zhongxiukechengService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhongxiukecheng), params), params));
        return R.ok().put("data", count);
    }



}
