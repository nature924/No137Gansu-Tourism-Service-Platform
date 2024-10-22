package com.entity.model;

import com.entity.JiudianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 酒店
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiudianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商家
     */
    private Integer shangjiaId;


    /**
     * 房间名称
     */
    private String jiudianName;


    /**
     * 房间编号
     */
    private String jiudianUuidNumber;


    /**
     * 房间照片
     */
    private String jiudianPhoto;


    /**
     * 酒店位置
     */
    private String jiudianAddress;


    /**
     * 特色
     */
    private String jiudianTese;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 房型
     */
    private Integer jiudianTypes;


    /**
     * 剩余房间数
     */
    private Integer jiudianKucunNumber;


    /**
     * 房间原价
     */
    private Double jiudianOldMoney;


    /**
     * 现价/天
     */
    private Double jiudianNewMoney;


    /**
     * 房间热度
     */
    private Integer jiudianClicknum;


    /**
     * 房间介绍
     */
    private String jiudianContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer jiudianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
