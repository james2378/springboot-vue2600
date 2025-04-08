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
 * 物品进出登记
 *
 * @author 
 * @email
 */
@TableName("wupinjinchu")
public class WupinjinchuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WupinjinchuEntity() {

	}

	public WupinjinchuEntity(T t) {
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
     * 楼栋
     */
    @TableField(value = "loudong_types")

    private Integer loudongTypes;


    /**
     * 物品名称
     */
    @TableField(value = "wupinjinchu_name")

    private String wupinjinchuName;


    /**
     * 物品类型
     */
    @TableField(value = "wupinjinchu_types")

    private Integer wupinjinchuTypes;


    /**
     * 物品详情
     */
    @TableField(value = "wupinjinchu_content")

    private String wupinjinchuContent;


    /**
     * 状态
     */
    @TableField(value = "wupinjinchu_zhuangtai_types")

    private Integer wupinjinchuZhuangtaiTypes;


    /**
     * 进出时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "jinchu_time")

    private Date jinchuTime;


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
	 * 设置：楼栋
	 */
    public Integer getLoudongTypes() {
        return loudongTypes;
    }


    /**
	 * 获取：楼栋
	 */

    public void setLoudongTypes(Integer loudongTypes) {
        this.loudongTypes = loudongTypes;
    }
    /**
	 * 设置：物品名称
	 */
    public String getWupinjinchuName() {
        return wupinjinchuName;
    }


    /**
	 * 获取：物品名称
	 */

    public void setWupinjinchuName(String wupinjinchuName) {
        this.wupinjinchuName = wupinjinchuName;
    }
    /**
	 * 设置：物品类型
	 */
    public Integer getWupinjinchuTypes() {
        return wupinjinchuTypes;
    }


    /**
	 * 获取：物品类型
	 */

    public void setWupinjinchuTypes(Integer wupinjinchuTypes) {
        this.wupinjinchuTypes = wupinjinchuTypes;
    }
    /**
	 * 设置：物品详情
	 */
    public String getWupinjinchuContent() {
        return wupinjinchuContent;
    }


    /**
	 * 获取：物品详情
	 */

    public void setWupinjinchuContent(String wupinjinchuContent) {
        this.wupinjinchuContent = wupinjinchuContent;
    }
    /**
	 * 设置：状态
	 */
    public Integer getWupinjinchuZhuangtaiTypes() {
        return wupinjinchuZhuangtaiTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setWupinjinchuZhuangtaiTypes(Integer wupinjinchuZhuangtaiTypes) {
        this.wupinjinchuZhuangtaiTypes = wupinjinchuZhuangtaiTypes;
    }
    /**
	 * 设置：进出时间
	 */
    public Date getJinchuTime() {
        return jinchuTime;
    }


    /**
	 * 获取：进出时间
	 */

    public void setJinchuTime(Date jinchuTime) {
        this.jinchuTime = jinchuTime;
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
        return "Wupinjinchu{" +
            "id=" + id +
            ", loudongTypes=" + loudongTypes +
            ", wupinjinchuName=" + wupinjinchuName +
            ", wupinjinchuTypes=" + wupinjinchuTypes +
            ", wupinjinchuContent=" + wupinjinchuContent +
            ", wupinjinchuZhuangtaiTypes=" + wupinjinchuZhuangtaiTypes +
            ", jinchuTime=" + jinchuTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
