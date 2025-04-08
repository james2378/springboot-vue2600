
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
 * 住宿信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhusu")
public class ZhusuController {
    private static final Logger logger = LoggerFactory.getLogger(ZhusuController.class);

    @Autowired
    private ZhusuService zhusuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private SusheService susheService;
    @Autowired
    private XueshengService xueshengService;

    @Autowired
    private SusheguanliyuanService susheguanliyuanService;


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
        PageUtils page = zhusuService.queryPage(params);

        //字典表数据转换
        List<ZhusuView> list =(List<ZhusuView>)page.getList();
        for(ZhusuView c:list){
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
        ZhusuEntity zhusu = zhusuService.selectById(id);
        if(zhusu !=null){
            //entity转view
            ZhusuView view = new ZhusuView();
            BeanUtils.copyProperties( zhusu , view );//把实体数据重构到view中

                //级联表
                SusheEntity sushe = susheService.selectById(zhusu.getSusheId());
                if(sushe != null){
                    BeanUtils.copyProperties( sushe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSusheId(sushe.getId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(zhusu.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
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
    public R save(@RequestBody ZhusuEntity zhusu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhusu:{}",this.getClass().getName(),zhusu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("学生".equals(role))
            zhusu.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("宿舍".equals(role))
            zhusu.setSusheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZhusuEntity> queryWrapper = new EntityWrapper<ZhusuEntity>()
            .eq("xuesheng_id", zhusu.getXueshengId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhusuEntity zhusuEntity = zhusuService.selectOne(queryWrapper);
        if(zhusuEntity==null){
            zhusu.setInsertTime(new Date());
            zhusu.setCreateTime(new Date());
            zhusuService.insert(zhusu);
            return R.ok();
        }else {
            return R.error(511,"该学生已绑定宿舍");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhusuEntity zhusu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhusu:{}",this.getClass().getName(),zhusu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("学生".equals(role))
//            zhusu.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("宿舍".equals(role))
//            zhusu.setSusheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZhusuEntity> queryWrapper = new EntityWrapper<ZhusuEntity>()
            .notIn("id",zhusu.getId())
            .andNew()
            .eq("xuesheng_id", zhusu.getXueshengId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhusuEntity zhusuEntity = zhusuService.selectOne(queryWrapper);
        if(zhusuEntity==null){
            zhusuService.updateById(zhusu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该学生已绑定宿舍");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zhusuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZhusuEntity> zhusuList = new ArrayList<>();//上传的东西
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
                            ZhusuEntity zhusuEntity = new ZhusuEntity();
//                            zhusuEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            zhusuEntity.setSusheId(Integer.valueOf(data.get(0)));   //宿舍 要改的
//                            zhusuEntity.setZhusuContent("");//照片
//                            zhusuEntity.setInsertTime(date);//时间
//                            zhusuEntity.setCreateTime(date);//时间
                            zhusuList.add(zhusuEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zhusuService.insertBatch(zhusuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
