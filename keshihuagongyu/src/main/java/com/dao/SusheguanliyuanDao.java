package com.dao;

import com.entity.SusheguanliyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SusheguanliyuanView;

/**
 * 宿舍管理员 Dao 接口
 *
 * @author 
 */
public interface SusheguanliyuanDao extends BaseMapper<SusheguanliyuanEntity> {

   List<SusheguanliyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
