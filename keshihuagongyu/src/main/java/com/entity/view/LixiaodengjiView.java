package com.entity.view;

import com.entity.LixiaodengjiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 离校登记
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("lixiaodengji")
public class LixiaodengjiView extends LixiaodengjiEntity implements Serializable {
    private static final long serialVersionUID = 1L;




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

	public LixiaodengjiView() {

	}

	public LixiaodengjiView(LixiaodengjiEntity lixiaodengjiEntity) {
		try {
			BeanUtils.copyProperties(this, lixiaodengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
