package com.entity.view;

import com.entity.WupinjinchuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 物品进出登记
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("wupinjinchu")
public class WupinjinchuView extends WupinjinchuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 楼栋的值
		*/
		private String loudongValue;
		/**
		* 物品类型的值
		*/
		private String wupinjinchuValue;
		/**
		* 状态的值
		*/
		private String wupinjinchuZhuangtaiValue;



	public WupinjinchuView() {

	}

	public WupinjinchuView(WupinjinchuEntity wupinjinchuEntity) {
		try {
			BeanUtils.copyProperties(this, wupinjinchuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 楼栋的值
			*/
			public String getLoudongValue() {
				return loudongValue;
			}
			/**
			* 设置： 楼栋的值
			*/
			public void setLoudongValue(String loudongValue) {
				this.loudongValue = loudongValue;
			}
			/**
			* 获取： 物品类型的值
			*/
			public String getWupinjinchuValue() {
				return wupinjinchuValue;
			}
			/**
			* 设置： 物品类型的值
			*/
			public void setWupinjinchuValue(String wupinjinchuValue) {
				this.wupinjinchuValue = wupinjinchuValue;
			}
			/**
			* 获取： 状态的值
			*/
			public String getWupinjinchuZhuangtaiValue() {
				return wupinjinchuZhuangtaiValue;
			}
			/**
			* 设置： 状态的值
			*/
			public void setWupinjinchuZhuangtaiValue(String wupinjinchuZhuangtaiValue) {
				this.wupinjinchuZhuangtaiValue = wupinjinchuZhuangtaiValue;
			}














}
