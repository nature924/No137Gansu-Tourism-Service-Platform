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
 * 景点门票订单
 *
 * @author 
 * @email
 */
@TableName("jingdian_order")
public class JingdianOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JingdianOrderEntity() {

	}

	public JingdianOrderEntity(T t) {
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
    @TableField(value = "jingdian_order_uuid_number")

    private String jingdianOrderUuidNumber;


    /**
     * 景点
     */
    @ColumnInfo(comment="景点",type="int(11)")
    @TableField(value = "jingdian_id")

    private Integer jingdianId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 购买张数
     */
    @ColumnInfo(comment="购买张数",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 预定日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="预定日期",type="date")
    @TableField(value = "jingdian_order_time")

    private Date jingdianOrderTime;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "jingdian_order_true_price")

    private Double jingdianOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "jingdian_order_types")

    private Integer jingdianOrderTypes;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "jingdian_order_payment_types")

    private Integer jingdianOrderPaymentTypes;


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
    public String getJingdianOrderUuidNumber() {
        return jingdianOrderUuidNumber;
    }
    /**
	 * 设置：订单编号
	 */

    public void setJingdianOrderUuidNumber(String jingdianOrderUuidNumber) {
        this.jingdianOrderUuidNumber = jingdianOrderUuidNumber;
    }
    /**
	 * 获取：景点
	 */
    public Integer getJingdianId() {
        return jingdianId;
    }
    /**
	 * 设置：景点
	 */

    public void setJingdianId(Integer jingdianId) {
        this.jingdianId = jingdianId;
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
	 * 获取：购买张数
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }
    /**
	 * 设置：购买张数
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：预定日期
	 */
    public Date getJingdianOrderTime() {
        return jingdianOrderTime;
    }
    /**
	 * 设置：预定日期
	 */

    public void setJingdianOrderTime(Date jingdianOrderTime) {
        this.jingdianOrderTime = jingdianOrderTime;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getJingdianOrderTruePrice() {
        return jingdianOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setJingdianOrderTruePrice(Double jingdianOrderTruePrice) {
        this.jingdianOrderTruePrice = jingdianOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getJingdianOrderTypes() {
        return jingdianOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setJingdianOrderTypes(Integer jingdianOrderTypes) {
        this.jingdianOrderTypes = jingdianOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getJingdianOrderPaymentTypes() {
        return jingdianOrderPaymentTypes;
    }
    /**
	 * 设置：支付类型
	 */

    public void setJingdianOrderPaymentTypes(Integer jingdianOrderPaymentTypes) {
        this.jingdianOrderPaymentTypes = jingdianOrderPaymentTypes;
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
        return "JingdianOrder{" +
            ", id=" + id +
            ", jingdianOrderUuidNumber=" + jingdianOrderUuidNumber +
            ", jingdianId=" + jingdianId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", jingdianOrderTime=" + DateUtil.convertString(jingdianOrderTime,"yyyy-MM-dd") +
            ", jingdianOrderTruePrice=" + jingdianOrderTruePrice +
            ", jingdianOrderTypes=" + jingdianOrderTypes +
            ", jingdianOrderPaymentTypes=" + jingdianOrderPaymentTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
