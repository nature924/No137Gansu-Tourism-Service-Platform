package com.entity.vo;

import com.entity.JingdianOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 景点门票订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jingdian_order")
public class JingdianOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "jingdian_order_uuid_number")
    private String jingdianOrderUuidNumber;


    /**
     * 景点
     */

    @TableField(value = "jingdian_id")
    private Integer jingdianId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买张数
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 预定日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jingdian_order_time")
    private Date jingdianOrderTime;


    /**
     * 实付价格
     */

    @TableField(value = "jingdian_order_true_price")
    private Double jingdianOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "jingdian_order_types")
    private Integer jingdianOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "jingdian_order_payment_types")
    private Integer jingdianOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：订单编号
	 */
    public String getJingdianOrderUuidNumber() {
        return jingdianOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setJingdianOrderUuidNumber(String jingdianOrderUuidNumber) {
        this.jingdianOrderUuidNumber = jingdianOrderUuidNumber;
    }
    /**
	 * 设置：景点
	 */
    public Integer getJingdianId() {
        return jingdianId;
    }


    /**
	 * 获取：景点
	 */

    public void setJingdianId(Integer jingdianId) {
        this.jingdianId = jingdianId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买张数
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买张数
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：预定日期
	 */
    public Date getJingdianOrderTime() {
        return jingdianOrderTime;
    }


    /**
	 * 获取：预定日期
	 */

    public void setJingdianOrderTime(Date jingdianOrderTime) {
        this.jingdianOrderTime = jingdianOrderTime;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getJingdianOrderTruePrice() {
        return jingdianOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setJingdianOrderTruePrice(Double jingdianOrderTruePrice) {
        this.jingdianOrderTruePrice = jingdianOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getJingdianOrderTypes() {
        return jingdianOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setJingdianOrderTypes(Integer jingdianOrderTypes) {
        this.jingdianOrderTypes = jingdianOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getJingdianOrderPaymentTypes() {
        return jingdianOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setJingdianOrderPaymentTypes(Integer jingdianOrderPaymentTypes) {
        this.jingdianOrderPaymentTypes = jingdianOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
