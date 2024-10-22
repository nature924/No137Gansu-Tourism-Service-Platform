package com.entity.vo;

import com.entity.JiudianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 酒店
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiudian")
public class JiudianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商家
     */

    @TableField(value = "shangjia_id")
    private Integer shangjiaId;


    /**
     * 房间名称
     */

    @TableField(value = "jiudian_name")
    private String jiudianName;


    /**
     * 房间编号
     */

    @TableField(value = "jiudian_uuid_number")
    private String jiudianUuidNumber;


    /**
     * 房间照片
     */

    @TableField(value = "jiudian_photo")
    private String jiudianPhoto;


    /**
     * 酒店位置
     */

    @TableField(value = "jiudian_address")
    private String jiudianAddress;


    /**
     * 特色
     */

    @TableField(value = "jiudian_tese")
    private String jiudianTese;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 房型
     */

    @TableField(value = "jiudian_types")
    private Integer jiudianTypes;


    /**
     * 剩余房间数
     */

    @TableField(value = "jiudian_kucun_number")
    private Integer jiudianKucunNumber;


    /**
     * 房间原价
     */

    @TableField(value = "jiudian_old_money")
    private Double jiudianOldMoney;


    /**
     * 现价/天
     */

    @TableField(value = "jiudian_new_money")
    private Double jiudianNewMoney;


    /**
     * 房间热度
     */

    @TableField(value = "jiudian_clicknum")
    private Integer jiudianClicknum;


    /**
     * 房间介绍
     */

    @TableField(value = "jiudian_content")
    private String jiudianContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiudian_delete")
    private Integer jiudianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 获取：商家
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 设置：房间名称
	 */
    public String getJiudianName() {
        return jiudianName;
    }


    /**
	 * 获取：房间名称
	 */

    public void setJiudianName(String jiudianName) {
        this.jiudianName = jiudianName;
    }
    /**
	 * 设置：房间编号
	 */
    public String getJiudianUuidNumber() {
        return jiudianUuidNumber;
    }


    /**
	 * 获取：房间编号
	 */

    public void setJiudianUuidNumber(String jiudianUuidNumber) {
        this.jiudianUuidNumber = jiudianUuidNumber;
    }
    /**
	 * 设置：房间照片
	 */
    public String getJiudianPhoto() {
        return jiudianPhoto;
    }


    /**
	 * 获取：房间照片
	 */

    public void setJiudianPhoto(String jiudianPhoto) {
        this.jiudianPhoto = jiudianPhoto;
    }
    /**
	 * 设置：酒店位置
	 */
    public String getJiudianAddress() {
        return jiudianAddress;
    }


    /**
	 * 获取：酒店位置
	 */

    public void setJiudianAddress(String jiudianAddress) {
        this.jiudianAddress = jiudianAddress;
    }
    /**
	 * 设置：特色
	 */
    public String getJiudianTese() {
        return jiudianTese;
    }


    /**
	 * 获取：特色
	 */

    public void setJiudianTese(String jiudianTese) {
        this.jiudianTese = jiudianTese;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：房型
	 */
    public Integer getJiudianTypes() {
        return jiudianTypes;
    }


    /**
	 * 获取：房型
	 */

    public void setJiudianTypes(Integer jiudianTypes) {
        this.jiudianTypes = jiudianTypes;
    }
    /**
	 * 设置：剩余房间数
	 */
    public Integer getJiudianKucunNumber() {
        return jiudianKucunNumber;
    }


    /**
	 * 获取：剩余房间数
	 */

    public void setJiudianKucunNumber(Integer jiudianKucunNumber) {
        this.jiudianKucunNumber = jiudianKucunNumber;
    }
    /**
	 * 设置：房间原价
	 */
    public Double getJiudianOldMoney() {
        return jiudianOldMoney;
    }


    /**
	 * 获取：房间原价
	 */

    public void setJiudianOldMoney(Double jiudianOldMoney) {
        this.jiudianOldMoney = jiudianOldMoney;
    }
    /**
	 * 设置：现价/天
	 */
    public Double getJiudianNewMoney() {
        return jiudianNewMoney;
    }


    /**
	 * 获取：现价/天
	 */

    public void setJiudianNewMoney(Double jiudianNewMoney) {
        this.jiudianNewMoney = jiudianNewMoney;
    }
    /**
	 * 设置：房间热度
	 */
    public Integer getJiudianClicknum() {
        return jiudianClicknum;
    }


    /**
	 * 获取：房间热度
	 */

    public void setJiudianClicknum(Integer jiudianClicknum) {
        this.jiudianClicknum = jiudianClicknum;
    }
    /**
	 * 设置：房间介绍
	 */
    public String getJiudianContent() {
        return jiudianContent;
    }


    /**
	 * 获取：房间介绍
	 */

    public void setJiudianContent(String jiudianContent) {
        this.jiudianContent = jiudianContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiudianDelete() {
        return jiudianDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiudianDelete(Integer jiudianDelete) {
        this.jiudianDelete = jiudianDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
