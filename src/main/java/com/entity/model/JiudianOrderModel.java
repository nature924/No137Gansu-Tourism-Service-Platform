package com.entity.model;

import com.entity.JiudianOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 酒店订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiudianOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String jiudianOrderUuidNumber;


    /**
     * 房间
     */
    private Integer jiudianId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预定天数
     */
    private Integer buyNumber;


    /**
     * 预定入住日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jiudianOrderTime;


    /**
     * 实付价格
     */
    private Double jiudianOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer jiudianOrderTypes;


    /**
     * 支付类型
     */
    private Integer jiudianOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
