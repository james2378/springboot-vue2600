package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.JiaofeijiluEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 宿舍缴费记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiaofeijilu")
public class JiaofeijiluView extends JiaofeijiluEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 缴费类型的值
		*/
		private String jiaofeiValue;



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

	public JiaofeijiluView() {

	}

	public JiaofeijiluView(JiaofeijiluEntity jiaofeijiluEntity) {
		try {
			BeanUtils.copyProperties(this, jiaofeijiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 缴费类型的值
			*/
			public String getJiaofeiValue() {
				return jiaofeiValue;
			}
			/**
			* 设置： 缴费类型的值
			*/
			public void setJiaofeiValue(String jiaofeiValue) {
				this.jiaofeiValue = jiaofeiValue;
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
