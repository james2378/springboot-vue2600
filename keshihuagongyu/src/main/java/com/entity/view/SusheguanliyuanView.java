package com.entity.view;

import com.entity.SusheguanliyuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 宿舍管理员
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("susheguanliyuan")
public class SusheguanliyuanView extends SusheguanliyuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		private String sexValue;



		//级联表 banji
			/**
			* 班级名称
			*/
			private String banjiName;
			/**
			* 班级位置
			*/
			private String banjiAddress;
			/**
			* 班级人数
			*/
			private Integer banjiNumber;
			/**
			* 备注
			*/
			private String banjiContent;

	public SusheguanliyuanView() {

	}

	public SusheguanliyuanView(SusheguanliyuanEntity susheguanliyuanEntity) {
		try {
			BeanUtils.copyProperties(this, susheguanliyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}




				//级联表的get和set banji
					/**
					* 获取： 班级名称
					*/
					public String getBanjiName() {
						return banjiName;
					}
					/**
					* 设置： 班级名称
					*/
					public void setBanjiName(String banjiName) {
						this.banjiName = banjiName;
					}
					/**
					* 获取： 班级位置
					*/
					public String getBanjiAddress() {
						return banjiAddress;
					}
					/**
					* 设置： 班级位置
					*/
					public void setBanjiAddress(String banjiAddress) {
						this.banjiAddress = banjiAddress;
					}
					/**
					* 获取： 班级人数
					*/
					public Integer getBanjiNumber() {
						return banjiNumber;
					}
					/**
					* 设置： 班级人数
					*/
					public void setBanjiNumber(Integer banjiNumber) {
						this.banjiNumber = banjiNumber;
					}
					/**
					* 获取： 备注
					*/
					public String getBanjiContent() {
						return banjiContent;
					}
					/**
					* 设置： 备注
					*/
					public void setBanjiContent(String banjiContent) {
						this.banjiContent = banjiContent;
					}






















}
