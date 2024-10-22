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
 * 酒店
 *
 * @author 
 * @email
 */
@TableName("jiudian")
public class JiudianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiudianEntity() {

	}

	public JiudianEntity(T t) {
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
     * 房间名称
     */
    @ColumnInfo(comment="房间名称",type="varchar(200)")
    @TableField(value = "jiudian_name")

    private String jiudianName;


    /**
     * 房间编号
     */
    @ColumnInfo(comment="房间编号",type="varchar(200)")
    @TableField(value = "jiudian_uuid_number")

    private String jiudianUuidNumber;


    /**
     * 房间照片
     */
    @ColumnInfo(comment="房间照片",type="varchar(200)")
    @TableField(value = "jiudian_photo")

    private String jiudianPhoto;


    /**
     * 酒店位置
     */
    @ColumnInfo(comment="酒店位置",type="varchar(200)")
    @TableField(value = "jiudian_address")

    private String jiudianAddress;


    /**
     * 特色
     */
    @ColumnInfo(comment="特色",type="varchar(200)")
    @TableField(value = "jiudian_tese")

    private String jiudianTese;


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
     * 房型
     */
    @ColumnInfo(comment="房型",type="int(11)")
    @TableField(value = "jiudian_types")

    private Integer jiudianTypes;


    /**
     * 剩余房间数
     */
    @ColumnInfo(comment="剩余房间数",type="int(11)")
    @TableField(value = "jiudian_kucun_number")

    private Integer jiudianKucunNumber;


    /**
     * 房间原价
     */
    @ColumnInfo(comment="房间原价",type="decimal(10,2)")
    @TableField(value = "jiudian_old_money")

    private Double jiudianOldMoney;


    /**
     * 现价/天
     */
    @ColumnInfo(comment="现价/天",type="decimal(10,2)")
    @TableField(value = "jiudian_new_money")

    private Double jiudianNewMoney;


    /**
     * 房间热度
     */
    @ColumnInfo(comment="房间热度",type="int(11)")
    @TableField(value = "jiudian_clicknum")

    private Integer jiudianClicknum;


    /**
     * 房间介绍
     */
    @ColumnInfo(comment="房间介绍",type="longtext")
    @TableField(value = "jiudian_content")

    private String jiudianContent;


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
    @TableField(value = "jiudian_delete")

    private Integer jiudianDelete;


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
	 * 获取：房间名称
	 */
    public String getJiudianName() {
        return jiudianName;
    }
    /**
	 * 设置：房间名称
	 */

    public void setJiudianName(String jiudianName) {
        this.jiudianName = jiudianName;
    }
    /**
	 * 获取：房间编号
	 */
    public String getJiudianUuidNumber() {
        return jiudianUuidNumber;
    }
    /**
	 * 设置：房间编号
	 */

    public void setJiudianUuidNumber(String jiudianUuidNumber) {
        this.jiudianUuidNumber = jiudianUuidNumber;
    }
    /**
	 * 获取：房间照片
	 */
    public String getJiudianPhoto() {
        return jiudianPhoto;
    }
    /**
	 * 设置：房间照片
	 */

    public void setJiudianPhoto(String jiudianPhoto) {
        this.jiudianPhoto = jiudianPhoto;
    }
    /**
	 * 获取：酒店位置
	 */
    public String getJiudianAddress() {
        return jiudianAddress;
    }
    /**
	 * 设置：酒店位置
	 */

    public void setJiudianAddress(String jiudianAddress) {
        this.jiudianAddress = jiudianAddress;
    }
    /**
	 * 获取：特色
	 */
    public String getJiudianTese() {
        return jiudianTese;
    }
    /**
	 * 设置：特色
	 */

    public void setJiudianTese(String jiudianTese) {
        this.jiudianTese = jiudianTese;
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
	 * 获取：房型
	 */
    public Integer getJiudianTypes() {
        return jiudianTypes;
    }
    /**
	 * 设置：房型
	 */

    public void setJiudianTypes(Integer jiudianTypes) {
        this.jiudianTypes = jiudianTypes;
    }
    /**
	 * 获取：剩余房间数
	 */
    public Integer getJiudianKucunNumber() {
        return jiudianKucunNumber;
    }
    /**
	 * 设置：剩余房间数
	 */

    public void setJiudianKucunNumber(Integer jiudianKucunNumber) {
        this.jiudianKucunNumber = jiudianKucunNumber;
    }
    /**
	 * 获取：房间原价
	 */
    public Double getJiudianOldMoney() {
        return jiudianOldMoney;
    }
    /**
	 * 设置：房间原价
	 */

    public void setJiudianOldMoney(Double jiudianOldMoney) {
        this.jiudianOldMoney = jiudianOldMoney;
    }
    /**
	 * 获取：现价/天
	 */
    public Double getJiudianNewMoney() {
        return jiudianNewMoney;
    }
    /**
	 * 设置：现价/天
	 */

    public void setJiudianNewMoney(Double jiudianNewMoney) {
        this.jiudianNewMoney = jiudianNewMoney;
    }
    /**
	 * 获取：房间热度
	 */
    public Integer getJiudianClicknum() {
        return jiudianClicknum;
    }
    /**
	 * 设置：房间热度
	 */

    public void setJiudianClicknum(Integer jiudianClicknum) {
        this.jiudianClicknum = jiudianClicknum;
    }
    /**
	 * 获取：房间介绍
	 */
    public String getJiudianContent() {
        return jiudianContent;
    }
    /**
	 * 设置：房间介绍
	 */

    public void setJiudianContent(String jiudianContent) {
        this.jiudianContent = jiudianContent;
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
    public Integer getJiudianDelete() {
        return jiudianDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJiudianDelete(Integer jiudianDelete) {
        this.jiudianDelete = jiudianDelete;
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
        return "Jiudian{" +
            ", id=" + id +
            ", shangjiaId=" + shangjiaId +
            ", jiudianName=" + jiudianName +
            ", jiudianUuidNumber=" + jiudianUuidNumber +
            ", jiudianPhoto=" + jiudianPhoto +
            ", jiudianAddress=" + jiudianAddress +
            ", jiudianTese=" + jiudianTese +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", jiudianTypes=" + jiudianTypes +
            ", jiudianKucunNumber=" + jiudianKucunNumber +
            ", jiudianOldMoney=" + jiudianOldMoney +
            ", jiudianNewMoney=" + jiudianNewMoney +
            ", jiudianClicknum=" + jiudianClicknum +
            ", jiudianContent=" + jiudianContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", jiudianDelete=" + jiudianDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
