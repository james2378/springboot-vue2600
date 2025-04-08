package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 宿舍缴费记录
 *
 * @author 
 * @email
 */
@TableName("jiaofeijilu")
public class JiaofeijiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaofeijiluEntity() {

	}

	public JiaofeijiluEntity(T t) {
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
     * 宿舍
     */
    @TableField(value = "sushe_id")

    private Integer susheId;


    /**
     * 缴费名称
     */
    @TableField(value = "jiaofeijilu_name")

    private String jiaofeijiluName;


    /**
     * 缴费类型
     */
    @TableField(value = "jiaofei_types")

    private Integer jiaofeiTypes;


    /**
     * 备注
     */
    @TableField(value = "jiaofeijilu_content")

    private String jiaofeijiluContent;


    /**
     * 缴费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "jiaofei_time")

    private Date jiaofeiTime;


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
     * 缴费金额
     */
    @TableField(value = "jiaofei_number")

    private Double jiaofeiNumber;


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
	 * 设置：宿舍
	 */
    public Integer getSusheId() {
        return susheId;
    }


    /**
	 * 获取：宿舍
	 */

    public void setSusheId(Integer susheId) {
        this.susheId = susheId;
    }
    /**
	 * 设置：缴费名称
	 */
    public String getJiaofeijiluName() {
        return jiaofeijiluName;
    }


    /**
	 * 获取：缴费名称
	 */

    public void setJiaofeijiluName(String jiaofeijiluName) {
        this.jiaofeijiluName = jiaofeijiluName;
    }
    /**
	 * 设置：缴费类型
	 */
    public Integer getJiaofeiTypes() {
        return jiaofeiTypes;
    }


    /**
	 * 获取：缴费类型
	 */

    public void setJiaofeiTypes(Integer jiaofeiTypes) {
        this.jiaofeiTypes = jiaofeiTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getJiaofeijiluContent() {
        return jiaofeijiluContent;
    }


    /**
	 * 获取：备注
	 */

    public void setJiaofeijiluContent(String jiaofeijiluContent) {
        this.jiaofeijiluContent = jiaofeijiluContent;
    }
    /**
	 * 设置：缴费时间
	 */
    public Date getJiaofeiTime() {
        return jiaofeiTime;
    }


    /**
	 * 获取：缴费时间
	 */

    public void setJiaofeiTime(Date jiaofeiTime) {
        this.jiaofeiTime = jiaofeiTime;
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
    /**
	 * 设置：缴费金额
	 */
    public Double getJiaofeiNumber() {
        return jiaofeiNumber;
    }


    /**
	 * 获取：缴费金额
	 */

    public void setJiaofeiNumber(Double jiaofeiNumber) {
        this.jiaofeiNumber = jiaofeiNumber;
    }

    @Override
    public String toString() {
        return "Jiaofeijilu{" +
            "id=" + id +
            ", susheId=" + susheId +
            ", jiaofeijiluName=" + jiaofeijiluName +
            ", jiaofeiTypes=" + jiaofeiTypes +
            ", jiaofeijiluContent=" + jiaofeijiluContent +
            ", jiaofeiTime=" + jiaofeiTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
            ", jiaofeiNumber=" + jiaofeiNumber +
        "}";
    }
}
