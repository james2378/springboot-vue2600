package com.entity.model;

import com.entity.SusheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宿舍
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SusheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 宿舍房号
     */
    private String susheName;


    /**
     * 所属楼栋
     */
    private Integer loudongTypes;


    /**
     * 宿舍备注
     */
    private String susheContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：宿舍房号
	 */
    public String getSusheName() {
        return susheName;
    }


    /**
	 * 设置：宿舍房号
	 */
    public void setSusheName(String susheName) {
        this.susheName = susheName;
    }
    /**
	 * 获取：所属楼栋
	 */
    public Integer getLoudongTypes() {
        return loudongTypes;
    }


    /**
	 * 设置：所属楼栋
	 */
    public void setLoudongTypes(Integer loudongTypes) {
        this.loudongTypes = loudongTypes;
    }
    /**
	 * 获取：宿舍备注
	 */
    public String getSusheContent() {
        return susheContent;
    }


    /**
	 * 设置：宿舍备注
	 */
    public void setSusheContent(String susheContent) {
        this.susheContent = susheContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
