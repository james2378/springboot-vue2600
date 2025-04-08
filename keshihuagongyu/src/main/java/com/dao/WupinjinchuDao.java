package com.dao;

import com.entity.WupinjinchuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WupinjinchuView;

/**
 * 物品进出登记 Dao 接口
 *
 * @author 
 */
public interface WupinjinchuDao extends BaseMapper<WupinjinchuEntity> {

   List<WupinjinchuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
