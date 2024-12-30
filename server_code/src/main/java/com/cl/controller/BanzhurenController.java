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

import com.cl.entity.BanzhurenEntity;
import com.cl.entity.view.BanzhurenView;

import com.cl.service.BanzhurenService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.MapUtils;
import com.cl.utils.CommonUtil;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 班主任
 * 后端接口
 * @author 
 * @email 
 * @date 2024-11-09 21:00:50
 */
@RestController
@RequestMapping("/banzhuren")
public class BanzhurenController {
    @Autowired
    private BanzhurenService banzhurenService;



	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		BanzhurenEntity u = banzhurenService.selectOne(new EntityWrapper<BanzhurenEntity>().eq("jiaoshigonghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"banzhuren",  "班主任" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody BanzhurenEntity banzhuren){
    	//ValidatorUtils.validateEntity(banzhuren);
    	BanzhurenEntity u = banzhurenService.selectOne(new EntityWrapper<BanzhurenEntity>().eq("jiaoshigonghao", banzhuren.getJiaoshigonghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		banzhuren.setId(uId);
        banzhurenService.insert(banzhuren);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        return R.ok().put("data", banzhurenService.selectView(new EntityWrapper<BanzhurenEntity>().eq("id", id)));
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	BanzhurenEntity u = banzhurenService.selectOne(new EntityWrapper<BanzhurenEntity>().eq("jiaoshigonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        banzhurenService.updateById(u);
        return R.ok("密码已重置为：123456");
    }




    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BanzhurenEntity banzhuren,
		HttpServletRequest request){
        EntityWrapper<BanzhurenEntity> ew = new EntityWrapper<BanzhurenEntity>();

		PageUtils page = banzhurenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banzhuren), params), params));

        return R.ok().put("data", page);
    }
    
    
    
    
    
    
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BanzhurenEntity banzhuren, 
		HttpServletRequest request){
        EntityWrapper<BanzhurenEntity> ew = new EntityWrapper<BanzhurenEntity>();

		PageUtils page = banzhurenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banzhuren), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BanzhurenEntity banzhuren){
       	EntityWrapper<BanzhurenEntity> ew = new EntityWrapper<BanzhurenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( banzhuren, "banzhuren")); 
        return R.ok().put("data", banzhurenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BanzhurenEntity banzhuren){
        EntityWrapper< BanzhurenEntity> ew = new EntityWrapper< BanzhurenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( banzhuren, "banzhuren")); 
		BanzhurenView banzhurenView =  banzhurenService.selectView(ew);
		return R.ok("查询班主任成功").put("data", banzhurenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BanzhurenEntity banzhuren = banzhurenService.selectById(id);
		banzhuren = banzhurenService.selectView(new EntityWrapper<BanzhurenEntity>().eq("id", id));
        return R.ok().put("data", banzhuren);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BanzhurenEntity banzhuren = banzhurenService.selectById(id);
		banzhuren = banzhurenService.selectView(new EntityWrapper<BanzhurenEntity>().eq("id", id));
        return R.ok().put("data", banzhuren);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BanzhurenEntity banzhuren, HttpServletRequest request){
        if(banzhurenService.selectCount(new EntityWrapper<BanzhurenEntity>().eq("jiaoshigonghao", banzhuren.getJiaoshigonghao()))>0) {
            return R.error("教师工号已存在");
        }
    	banzhuren.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(banzhuren);
    	BanzhurenEntity u = banzhurenService.selectOne(new EntityWrapper<BanzhurenEntity>().eq("jiaoshigonghao", banzhuren.getJiaoshigonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		banzhuren.setId(new Date().getTime());
        banzhurenService.insert(banzhuren);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BanzhurenEntity banzhuren, HttpServletRequest request){
        if(banzhurenService.selectCount(new EntityWrapper<BanzhurenEntity>().eq("jiaoshigonghao", banzhuren.getJiaoshigonghao()))>0) {
            return R.error("教师工号已存在");
        }
    	banzhuren.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(banzhuren);
    	BanzhurenEntity u = banzhurenService.selectOne(new EntityWrapper<BanzhurenEntity>().eq("jiaoshigonghao", banzhuren.getJiaoshigonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		banzhuren.setId(new Date().getTime());
        banzhurenService.insert(banzhuren);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BanzhurenEntity banzhuren, HttpServletRequest request){
        //ValidatorUtils.validateEntity(banzhuren);
        banzhurenService.updateById(banzhuren);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        banzhurenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	




    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    BanzhurenEntity banzhurenEntity =new BanzhurenEntity();
                    banzhurenEntity.setId(new Date().getTime());
                    String jiaoshigonghao = CommonUtil.getCellValue(row.getCell(0));
                    banzhurenEntity.setJiaoshigonghao(jiaoshigonghao);
                    String mima = CommonUtil.getCellValue(row.getCell(1));
                    banzhurenEntity.setMima(mima);
                    String jiaoshixingming = CommonUtil.getCellValue(row.getCell(2));
                    banzhurenEntity.setJiaoshixingming(jiaoshixingming);
                    String xingbie = CommonUtil.getCellValue(row.getCell(3));
                    banzhurenEntity.setXingbie(xingbie);
                    String zhicheng = CommonUtil.getCellValue(row.getCell(4));
                    banzhurenEntity.setZhicheng(zhicheng);
                    String shouji = CommonUtil.getCellValue(row.getCell(5));
                    banzhurenEntity.setShouji(shouji);
                    String zhuanye = CommonUtil.getCellValue(row.getCell(6));
                    banzhurenEntity.setZhuanye(zhuanye);
                    String banji = CommonUtil.getCellValue(row.getCell(7));
                    banzhurenEntity.setBanji(banji);
                     
                    //想数据库中添加新对象
                    banzhurenService.insert(banzhurenEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }


    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,BanzhurenEntity banzhuren, HttpServletRequest request){
        EntityWrapper<BanzhurenEntity> ew = new EntityWrapper<BanzhurenEntity>();
        int count = banzhurenService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, banzhuren), params), params));
        return R.ok().put("data", count);
    }



}
