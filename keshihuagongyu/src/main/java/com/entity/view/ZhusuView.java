package com.entity.view;

import com.entity.ZhusuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 住宿信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhusu")
public class ZhusuView extends ZhusuEntity implements Serializable {
    private static final long serialVersionUID = 1L;




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

		//级联表 xuesheng
			/**
			* 学号
			*/
			private String xuehaoUuidNumber;
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;
			/**
			* 状态
			*/
			private Integer zhuangtaiTypes;
				/**
				* 状态的值
				*/
				private String zhuangtaiValue;
			/**
			* 财务登记
			*/
			private String xueshengContent;

	public ZhusuView() {

	}

	public ZhusuView(ZhusuEntity zhusuEntity) {
		try {
			BeanUtils.copyProperties(this, zhusuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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








				//级联表的get和set xuesheng

					/**
					* 获取： 学号
					*/
					public String getXuehaoUuidNumber() {
						return xuehaoUuidNumber;
					}
					/**
					* 设置： 学号
					*/
					public void setXuehaoUuidNumber(String xuehaoUuidNumber) {
						this.xuehaoUuidNumber = xuehaoUuidNumber;
					}
					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}
					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}
					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}
					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}
					/**
					* 获取： 状态
					*/
					public Integer getZhuangtaiTypes() {
						return zhuangtaiTypes;
					}
					/**
					* 设置： 状态
					*/
					public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
						this.zhuangtaiTypes = zhuangtaiTypes;
					}


						/**
						* 获取： 状态的值
						*/
						public String getZhuangtaiValue() {
							return zhuangtaiValue;
						}
						/**
						* 设置： 状态的值
						*/
						public void setZhuangtaiValue(String zhuangtaiValue) {
							this.zhuangtaiValue = zhuangtaiValue;
						}
					/**
					* 获取： 财务登记
					*/
					public String getXueshengContent() {
						return xueshengContent;
					}
					/**
					* 设置： 财务登记
					*/
					public void setXueshengContent(String xueshengContent) {
						this.xueshengContent = xueshengContent;
					}







}
