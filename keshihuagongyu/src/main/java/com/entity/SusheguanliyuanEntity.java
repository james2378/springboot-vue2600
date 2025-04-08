package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 宿舍管理员
 *
 * @author 
 * @email
 */
@TableName("susheguanliyuan")
public class SusheguanliyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SusheguanliyuanEntity() {

	}

	public SusheguanliyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 班级
     */
    @TableField(value = "banji_id")

    private Integer banjiId;


    /**
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 宿舍管理员姓名
     */
    @TableField(value = "susheguanliyuan_name")

    private String susheguanliyuanName;


    /**
     * 宿舍管理员手机号
     */
    @TableField(value = "susheguanliyuan_phone")

    private String susheguanliyuanPhone;


    /**
     * 宿舍管理员头像
     */
    @TableField(value = "susheguanliyuan_photo")

    private String susheguanliyuanPhoto;


    /**
     * 电子邮箱
     */
    @TableField(value = "susheguanliyuan_email")

    private String susheguanliyuanEmail;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：班级
	 */
    public Integer getBanjiId() {
        return banjiId;
    }


    /**
	 * 获取：班级
	 */

    public void setBanjiId(Integer banjiId) {
        this.banjiId = banjiId;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：宿舍管理员姓名
	 */
    public String getSusheguanliyuanName() {
        return susheguanliyuanName;
    }


    /**
	 * 获取：宿舍管理员姓名
	 */

    public void setSusheguanliyuanName(String susheguanliyuanName) {
        this.susheguanliyuanName = susheguanliyuanName;
    }
    /**
	 * 设置：宿舍管理员手机号
	 */
    public String getSusheguanliyuanPhone() {
        return susheguanliyuanPhone;
    }


    /**
	 * 获取：宿舍管理员手机号
	 */

    public void setSusheguanliyuanPhone(String susheguanliyuanPhone) {
        this.susheguanliyuanPhone = susheguanliyuanPhone;
    }
    /**
	 * 设置：宿舍管理员头像
	 */
    public String getSusheguanliyuanPhoto() {
        return susheguanliyuanPhoto;
    }


    /**
	 * 获取：宿舍管理员头像
	 */

    public void setSusheguanliyuanPhoto(String susheguanliyuanPhoto) {
        this.susheguanliyuanPhoto = susheguanliyuanPhoto;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getSusheguanliyuanEmail() {
        return susheguanliyuanEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setSusheguanliyuanEmail(String susheguanliyuanEmail) {
        this.susheguanliyuanEmail = susheguanliyuanEmail;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Susheguanliyuan{" +
            "id=" + id +
            ", banjiId=" + banjiId +
            ", username=" + username +
            ", password=" + password +
            ", susheguanliyuanName=" + susheguanliyuanName +
            ", susheguanliyuanPhone=" + susheguanliyuanPhone +
            ", susheguanliyuanPhoto=" + susheguanliyuanPhoto +
            ", susheguanliyuanEmail=" + susheguanliyuanEmail +
            ", sexTypes=" + sexTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
