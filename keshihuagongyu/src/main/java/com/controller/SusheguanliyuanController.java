
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 宿舍管理员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/susheguanliyuan")
public class SusheguanliyuanController {
    private static final Logger logger = LoggerFactory.getLogger(SusheguanliyuanController.class);

    @Autowired
    private SusheguanliyuanService susheguanliyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private BanjiService banjiService;

    @Autowired
    private XueshengService xueshengService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("宿舍管理员".equals(role))
            params.put("susheguanliyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = susheguanliyuanService.queryPage(params);

        //字典表数据转换
        List<SusheguanliyuanView> list =(List<SusheguanliyuanView>)page.getList();
        for(SusheguanliyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectById(id);
        if(susheguanliyuan !=null){
            //entity转view
            SusheguanliyuanView view = new SusheguanliyuanView();
            BeanUtils.copyProperties( susheguanliyuan , view );//把实体数据重构到view中

                //级联表
                BanjiEntity banji = banjiService.selectById(susheguanliyuan.getBanjiId());
                if(banji != null){
                    BeanUtils.copyProperties( banji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setBanjiId(banji.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody SusheguanliyuanEntity susheguanliyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,susheguanliyuan:{}",this.getClass().getName(),susheguanliyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        Wrapper<SusheguanliyuanEntity> queryWrapper = new EntityWrapper<SusheguanliyuanEntity>()
            .eq("username", susheguanliyuan.getUsername())
            .or()
            .eq("susheguanliyuan_phone", susheguanliyuan.getSusheguanliyuanPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SusheguanliyuanEntity susheguanliyuanEntity = susheguanliyuanService.selectOne(queryWrapper);
        if(susheguanliyuanEntity==null){
            susheguanliyuan.setInsertTime(new Date());
            susheguanliyuan.setCreateTime(new Date());
            susheguanliyuan.setPassword("123456");
            susheguanliyuanService.insert(susheguanliyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者宿舍管理员手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SusheguanliyuanEntity susheguanliyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,susheguanliyuan:{}",this.getClass().getName(),susheguanliyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<SusheguanliyuanEntity> queryWrapper = new EntityWrapper<SusheguanliyuanEntity>()
            .notIn("id",susheguanliyuan.getId())
            .andNew()
            .eq("username", susheguanliyuan.getUsername())
            .or()
            .eq("susheguanliyuan_phone", susheguanliyuan.getSusheguanliyuanPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SusheguanliyuanEntity susheguanliyuanEntity = susheguanliyuanService.selectOne(queryWrapper);
        if("".equals(susheguanliyuan.getSusheguanliyuanPhoto()) || "null".equals(susheguanliyuan.getSusheguanliyuanPhoto())){
                susheguanliyuan.setSusheguanliyuanPhoto(null);
        }
        if(susheguanliyuanEntity==null){
            susheguanliyuanService.updateById(susheguanliyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者宿舍管理员手机号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        susheguanliyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<SusheguanliyuanEntity> susheguanliyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            SusheguanliyuanEntity susheguanliyuanEntity = new SusheguanliyuanEntity();
//                            susheguanliyuanEntity.setBanjiId(Integer.valueOf(data.get(0)));   //班级 要改的
//                            susheguanliyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //susheguanliyuanEntity.setPassword("123456");//密码
//                            susheguanliyuanEntity.setSusheguanliyuanName(data.get(0));                    //宿舍管理员姓名 要改的
//                            susheguanliyuanEntity.setSusheguanliyuanPhone(data.get(0));                    //宿舍管理员手机号 要改的
//                            susheguanliyuanEntity.setSusheguanliyuanPhoto("");//照片
//                            susheguanliyuanEntity.setSusheguanliyuanEmail(data.get(0));                    //电子邮箱 要改的
//                            susheguanliyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            susheguanliyuanEntity.setInsertTime(date);//时间
//                            susheguanliyuanEntity.setCreateTime(date);//时间
                            susheguanliyuanList.add(susheguanliyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //宿舍管理员手机号
                                if(seachFields.containsKey("susheguanliyuanPhone")){
                                    List<String> susheguanliyuanPhone = seachFields.get("susheguanliyuanPhone");
                                    susheguanliyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> susheguanliyuanPhone = new ArrayList<>();
                                    susheguanliyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("susheguanliyuanPhone",susheguanliyuanPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<SusheguanliyuanEntity> susheguanliyuanEntities_username = susheguanliyuanService.selectList(new EntityWrapper<SusheguanliyuanEntity>().in("username", seachFields.get("username")));
                        if(susheguanliyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SusheguanliyuanEntity s:susheguanliyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //宿舍管理员手机号
                        List<SusheguanliyuanEntity> susheguanliyuanEntities_susheguanliyuanPhone = susheguanliyuanService.selectList(new EntityWrapper<SusheguanliyuanEntity>().in("susheguanliyuan_phone", seachFields.get("susheguanliyuanPhone")));
                        if(susheguanliyuanEntities_susheguanliyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SusheguanliyuanEntity s:susheguanliyuanEntities_susheguanliyuanPhone){
                                repeatFields.add(s.getSusheguanliyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [宿舍管理员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        susheguanliyuanService.insertBatch(susheguanliyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectOne(new EntityWrapper<SusheguanliyuanEntity>().eq("username", username));
        if(susheguanliyuan==null || !susheguanliyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(susheguanliyuan.getId(),username, "susheguanliyuan", "宿舍管理员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","宿舍管理员");
        r.put("username",susheguanliyuan.getSusheguanliyuanName());
        r.put("tableName","susheguanliyuan");
        r.put("userId",susheguanliyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody SusheguanliyuanEntity susheguanliyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<SusheguanliyuanEntity> queryWrapper = new EntityWrapper<SusheguanliyuanEntity>()
            .eq("username", susheguanliyuan.getUsername())
            .or()
            .eq("susheguanliyuan_phone", susheguanliyuan.getSusheguanliyuanPhone())
            ;
        SusheguanliyuanEntity susheguanliyuanEntity = susheguanliyuanService.selectOne(queryWrapper);
        if(susheguanliyuanEntity != null)
            return R.error("账户或者宿舍管理员手机号已经被使用");
        susheguanliyuan.setInsertTime(new Date());
        susheguanliyuan.setCreateTime(new Date());
        susheguanliyuanService.insert(susheguanliyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        SusheguanliyuanEntity susheguanliyuan = new SusheguanliyuanEntity();
        susheguanliyuan.setPassword("123456");
        susheguanliyuan.setId(id);
        susheguanliyuan.setInsertTime(new Date());
        susheguanliyuanService.updateById(susheguanliyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectOne(new EntityWrapper<SusheguanliyuanEntity>().eq("username", username));
        if(susheguanliyuan!=null){
            susheguanliyuan.setPassword("123456");
            boolean b = susheguanliyuanService.updateById(susheguanliyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrSusheguanliyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectById(id);
        if(susheguanliyuan !=null){
            //entity转view
            SusheguanliyuanView view = new SusheguanliyuanView();
            BeanUtils.copyProperties( susheguanliyuan , view );//把实体数据重构到view中

            //级联表
                            BanjiEntity banji = banjiService.selectById(susheguanliyuan.getBanjiId());
            if(banji != null){
                BeanUtils.copyProperties( banji , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setBanjiId(banji.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
