package com.entity.vo;

import com.entity.WupinjinchuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物品进出登记
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wupinjinchu")
public class WupinjinchuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
