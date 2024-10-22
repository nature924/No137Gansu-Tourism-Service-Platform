package com.entity.vo;

import com.entity.JiudianOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 酒店订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiudian_order")
public class JiudianOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "jiudian_order_uuid_number")
    private String jiudianOrderUuidNumber;


    /**
     * 房间
     */

    @TableField(value = "jiudian_id")
    private Integer jiudianId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预定天数
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 预定入住日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jiudian_order_time")
    private Date jiudianOrderTime;


    /**
     * 实付价格
     */

    @TableField(value = "jiudian_order_true_price")
    private Double jiudianOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "jiudian_order_types")
    private Integer jiudianOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "jiudian_order_payment_types")
    private Integer jiudianOrderPaymentTypes;


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
    public String getJiudianOrderUuidNumber() {
        return jiudianOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setJiudianOrderUuidNumber(String jiudianOrderUuidNumber) {
        this.jiudianOrderUuidNumber = jiudianOrderUuidNumber;
    }
    /**
	 * 设置：房间
	 */
    public Integer getJiudianId() {
        return jiudianId;
    }


    /**
	 * 获取：房间
	 */

    public void setJiudianId(Integer jiudianId) {
        this.jiudianId = jiudianId;
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
	 * 设置：预定天数
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：预定天数
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：预定入住日期
	 */
    public Date getJiudianOrderTime() {
        return jiudianOrderTime;
    }


    /**
	 * 获取：预定入住日期
	 */

    public void setJiudianOrderTime(Date jiudianOrderTime) {
        this.jiudianOrderTime = jiudianOrderTime;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getJiudianOrderTruePrice() {
        return jiudianOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setJiudianOrderTruePrice(Double jiudianOrderTruePrice) {
        this.jiudianOrderTruePrice = jiudianOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getJiudianOrderTypes() {
        return jiudianOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setJiudianOrderTypes(Integer jiudianOrderTypes) {
        this.jiudianOrderTypes = jiudianOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getJiudianOrderPaymentTypes() {
        return jiudianOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setJiudianOrderPaymentTypes(Integer jiudianOrderPaymentTypes) {
        this.jiudianOrderPaymentTypes = jiudianOrderPaymentTypes;
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
