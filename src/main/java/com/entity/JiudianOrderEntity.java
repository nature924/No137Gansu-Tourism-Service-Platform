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
 * 酒店订单
 *
 * @author 
 * @email
 */
@TableName("jiudian_order")
public class JiudianOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiudianOrderEntity() {

	}

	public JiudianOrderEntity(T t) {
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
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "jiudian_order_uuid_number")

    private String jiudianOrderUuidNumber;


    /**
     * 房间
     */
    @ColumnInfo(comment="房间",type="int(11)")
    @TableField(value = "jiudian_id")

    private Integer jiudianId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预定天数
     */
    @ColumnInfo(comment="预定天数",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 预定入住日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="预定入住日期",type="date")
    @TableField(value = "jiudian_order_time")

    private Date jiudianOrderTime;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "jiudian_order_true_price")

    private Double jiudianOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "jiudian_order_types")

    private Integer jiudianOrderTypes;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "jiudian_order_payment_types")

    private Integer jiudianOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：订单编号
	 */
    public String getJiudianOrderUuidNumber() {
        return jiudianOrderUuidNumber;
    }
    /**
	 * 设置：订单编号
	 */

    public void setJiudianOrderUuidNumber(String jiudianOrderUuidNumber) {
        this.jiudianOrderUuidNumber = jiudianOrderUuidNumber;
    }
    /**
	 * 获取：房间
	 */
    public Integer getJiudianId() {
        return jiudianId;
    }
    /**
	 * 设置：房间
	 */

    public void setJiudianId(Integer jiudianId) {
        this.jiudianId = jiudianId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预定天数
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }
    /**
	 * 设置：预定天数
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：预定入住日期
	 */
    public Date getJiudianOrderTime() {
        return jiudianOrderTime;
    }
    /**
	 * 设置：预定入住日期
	 */

    public void setJiudianOrderTime(Date jiudianOrderTime) {
        this.jiudianOrderTime = jiudianOrderTime;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getJiudianOrderTruePrice() {
        return jiudianOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setJiudianOrderTruePrice(Double jiudianOrderTruePrice) {
        this.jiudianOrderTruePrice = jiudianOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getJiudianOrderTypes() {
        return jiudianOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setJiudianOrderTypes(Integer jiudianOrderTypes) {
        this.jiudianOrderTypes = jiudianOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getJiudianOrderPaymentTypes() {
        return jiudianOrderPaymentTypes;
    }
    /**
	 * 设置：支付类型
	 */

    public void setJiudianOrderPaymentTypes(Integer jiudianOrderPaymentTypes) {
        this.jiudianOrderPaymentTypes = jiudianOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "JiudianOrder{" +
            ", id=" + id +
            ", jiudianOrderUuidNumber=" + jiudianOrderUuidNumber +
            ", jiudianId=" + jiudianId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", jiudianOrderTime=" + DateUtil.convertString(jiudianOrderTime,"yyyy-MM-dd") +
            ", jiudianOrderTruePrice=" + jiudianOrderTruePrice +
            ", jiudianOrderTypes=" + jiudianOrderTypes +
            ", jiudianOrderPaymentTypes=" + jiudianOrderPaymentTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
