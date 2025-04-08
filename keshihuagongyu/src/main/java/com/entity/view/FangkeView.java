package com.entity.view;

import com.entity.FangkeEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 访客
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangke")
public class FangkeView extends FangkeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		private String sexValue;



		//级联表 sushe
			/**
			* 宿舍房号
			*/
			private String susheName;
			/**
			* 所属楼栋
			*/
			private Integer loudongTypes;
				/**
				* 所属楼栋的值
				*/
				private String loudongValue;
			/**
			* 宿舍备注
			*/
			private String susheContent;

	public FangkeView() {

	}

	public FangkeView(FangkeEntity fangkeEntity) {
		try {
			BeanUtils.copyProperties(this, fangkeEntity);
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
















				//级联表的get和set sushe
					/**
					* 获取： 宿舍房号
					*/
					public String getSusheName() {
						return susheName;
					}
					/**
					* 设置： 宿舍房号
					*/
					public void setSusheName(String susheName) {
						this.susheName = susheName;
					}
					/**
					* 获取： 所属楼栋
					*/
					public Integer getLoudongTypes() {
						return loudongTypes;
					}
					/**
					* 设置： 所属楼栋
					*/
					public void setLoudongTypes(Integer loudongTypes) {
						this.loudongTypes = loudongTypes;
					}


						/**
						* 获取： 所属楼栋的值
						*/
						public String getLoudongValue() {
							return loudongValue;
						}
						/**
						* 设置： 所属楼栋的值
						*/
						public void setLoudongValue(String loudongValue) {
							this.loudongValue = loudongValue;
						}
					/**
					* 获取： 宿舍备注
					*/
					public String getSusheContent() {
						return susheContent;
					}
					/**
					* 设置： 宿舍备注
					*/
					public void setSusheContent(String susheContent) {
						this.susheContent = susheContent;
					}










}
