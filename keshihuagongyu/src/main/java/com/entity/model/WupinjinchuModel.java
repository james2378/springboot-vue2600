package com.entity.model;

import com.entity.WupinjinchuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物品进出登记
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WupinjinchuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 楼栋
     */
    private Integer loudongTypes;


    /**
     * 物品名称
     */
    private String wupinjinchuName;


    /**
     * 物品类型
     */
    private Integer wupinjinchuTypes;


    /**
     * 物品详情
     */
    private String wupinjinchuContent;


    /**
     * 状态
     */
    private Integer wupinjinchuZhuangtaiTypes;


    /**
     * 进出时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jinchuTime;


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
	 * 获取：楼栋
	 */
    public Integer getLoudongTypes() {
        return loudongTypes;
    }


    /**
	 * 设置：楼栋
	 */
    public void setLoudongTypes(Integer loudongTypes) {
        this.loudongTypes = loudongTypes;
    }
    /**
	 * 获取：物品名称
	 */
    public String getWupinjinchuName() {
        return wupinjinchuName;
    }


    /**
	 * 设置：物品名称
	 */
    public void setWupinjinchuName(String wupinjinchuName) {
        this.wupinjinchuName = wupinjinchuName;
    }
    /**
	 * 获取：物品类型
	 */
    public Integer getWupinjinchuTypes() {
        return wupinjinchuTypes;
    }


    /**
	 * 设置：物品类型
	 */
    public void setWupinjinchuTypes(Integer wupinjinchuTypes) {
        this.wupinjinchuTypes = wupinjinchuTypes;
    }
    /**
	 * 获取：物品详情
	 */
    public String getWupinjinchuContent() {
        return wupinjinchuContent;
    }


    /**
	 * 设置：物品详情
	 */
    public void setWupinjinchuContent(String wupinjinchuContent) {
        this.wupinjinchuContent = wupinjinchuContent;
    }
    /**
	 * 获取：状态
	 */
    public Integer getWupinjinchuZhuangtaiTypes() {
        return wupinjinchuZhuangtaiTypes;
    }


    /**
	 * 设置：状态
	 */
    public void setWupinjinchuZhuangtaiTypes(Integer wupinjinchuZhuangtaiTypes) {
        this.wupinjinchuZhuangtaiTypes = wupinjinchuZhuangtaiTypes;
    }
    /**
	 * 获取：进出时间
	 */
    public Date getJinchuTime() {
        return jinchuTime;
    }


    /**
	 * 设置：进出时间
	 */
    public void setJinchuTime(Date jinchuTime) {
        this.jinchuTime = jinchuTime;
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
