package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 美食
 *
 * @author 
 * @email
 */
@TableName("meishi")
public class MeishiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MeishiEntity() {

	}

	public MeishiEntity(T t) {
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
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 商家
     */
    @ColumnInfo(comment="商家",type="int(11)")
    @TableField(value = "shangjia_id")

    private Integer shangjiaId;


    /**
     * 美食名称
     */
    @ColumnInfo(comment="美食名称",type="varchar(200)")
    @TableField(value = "meishi_name")

    private String meishiName;


    /**
     * 美食编号
     */
    @ColumnInfo(comment="美食编号",type="varchar(200)")
    @TableField(value = "meishi_uuid_number")

    private String meishiUuidNumber;


    /**
     * 美食照片
     */
    @ColumnInfo(comment="美食照片",type="varchar(200)")
    @TableField(value = "meishi_photo")

    private String meishiPhoto;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 美食类型
     */
    @ColumnInfo(comment="美食类型",type="int(11)")
    @TableField(value = "meishi_types")

    private Integer meishiTypes;


    /**
     * 美食库存
     */
    @ColumnInfo(comment="美食库存",type="int(11)")
    @TableField(value = "meishi_kucun_number")

    private Integer meishiKucunNumber;


    /**
     * 美食原价
     */
    @ColumnInfo(comment="美食原价",type="decimal(10,2)")
    @TableField(value = "meishi_old_money")

    private Double meishiOldMoney;


    /**
     * 现价/份
     */
    @ColumnInfo(comment="现价/份",type="decimal(10,2)")
    @TableField(value = "meishi_new_money")

    private Double meishiNewMoney;


    /**
     * 美食热度
     */
    @ColumnInfo(comment="美食热度",type="int(11)")
    @TableField(value = "meishi_clicknum")

    private Integer meishiClicknum;


    /**
     * 美食介绍
     */
    @ColumnInfo(comment="美食介绍",type="longtext")
    @TableField(value = "meishi_content")

    private String meishiContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "meishi_delete")

    private Integer meishiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }
    /**
	 * 设置：商家
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 获取：美食名称
	 */
    public String getMeishiName() {
        return meishiName;
    }
    /**
	 * 设置：美食名称
	 */

    public void setMeishiName(String meishiName) {
        this.meishiName = meishiName;
    }
    /**
	 * 获取：美食编号
	 */
    public String getMeishiUuidNumber() {
        return meishiUuidNumber;
    }
    /**
	 * 设置：美食编号
	 */

    public void setMeishiUuidNumber(String meishiUuidNumber) {
        this.meishiUuidNumber = meishiUuidNumber;
    }
    /**
	 * 获取：美食照片
	 */
    public String getMeishiPhoto() {
        return meishiPhoto;
    }
    /**
	 * 设置：美食照片
	 */

    public void setMeishiPhoto(String meishiPhoto) {
        this.meishiPhoto = meishiPhoto;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：美食类型
	 */
    public Integer getMeishiTypes() {
        return meishiTypes;
    }
    /**
	 * 设置：美食类型
	 */

    public void setMeishiTypes(Integer meishiTypes) {
        this.meishiTypes = meishiTypes;
    }
    /**
	 * 获取：美食库存
	 */
    public Integer getMeishiKucunNumber() {
        return meishiKucunNumber;
    }
    /**
	 * 设置：美食库存
	 */

    public void setMeishiKucunNumber(Integer meishiKucunNumber) {
        this.meishiKucunNumber = meishiKucunNumber;
    }
    /**
	 * 获取：美食原价
	 */
    public Double getMeishiOldMoney() {
        return meishiOldMoney;
    }
    /**
	 * 设置：美食原价
	 */

    public void setMeishiOldMoney(Double meishiOldMoney) {
        this.meishiOldMoney = meishiOldMoney;
    }
    /**
	 * 获取：现价/份
	 */
    public Double getMeishiNewMoney() {
        return meishiNewMoney;
    }
    /**
	 * 设置：现价/份
	 */

    public void setMeishiNewMoney(Double meishiNewMoney) {
        this.meishiNewMoney = meishiNewMoney;
    }
    /**
	 * 获取：美食热度
	 */
    public Integer getMeishiClicknum() {
        return meishiClicknum;
    }
    /**
	 * 设置：美食热度
	 */

    public void setMeishiClicknum(Integer meishiClicknum) {
        this.meishiClicknum = meishiClicknum;
    }
    /**
	 * 获取：美食介绍
	 */
    public String getMeishiContent() {
        return meishiContent;
    }
    /**
	 * 设置：美食介绍
	 */

    public void setMeishiContent(String meishiContent) {
        this.meishiContent = meishiContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getMeishiDelete() {
        return meishiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setMeishiDelete(Integer meishiDelete) {
        this.meishiDelete = meishiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
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

    @Override
    public String toString() {
        return "Meishi{" +
            ", id=" + id +
            ", shangjiaId=" + shangjiaId +
            ", meishiName=" + meishiName +
            ", meishiUuidNumber=" + meishiUuidNumber +
            ", meishiPhoto=" + meishiPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", meishiTypes=" + meishiTypes +
            ", meishiKucunNumber=" + meishiKucunNumber +
            ", meishiOldMoney=" + meishiOldMoney +
            ", meishiNewMoney=" + meishiNewMoney +
            ", meishiClicknum=" + meishiClicknum +
            ", meishiContent=" + meishiContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", meishiDelete=" + meishiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
