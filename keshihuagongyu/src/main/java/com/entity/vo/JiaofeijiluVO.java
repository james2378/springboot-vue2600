package com.entity.vo;

import com.entity.JiaofeijiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宿舍缴费记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaofeijilu")
public class JiaofeijiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
