package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiudianCommentbackEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 酒店评价
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiudian_commentback")
public class JiudianCommentbackView extends JiudianCommentbackEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 酒店
					 
		/**
		* 酒店 的 商家
		*/
		@ColumnInfo(comment="商家",type="int(11)")
		private Integer jiudianShangjiaId;
		/**
		* 房间名称
		*/

		@ColumnInfo(comment="房间名称",type="varchar(200)")
		private String jiudianName;
		/**
		* 房间编号
		*/

		@ColumnInfo(comment="房间编号",type="varchar(200)")
		private String jiudianUuidNumber;
		/**
		* 房间照片
		*/

		@ColumnInfo(comment="房间照片",type="varchar(200)")
		private String jiudianPhoto;
		/**
		* 酒店位置
		*/

		@ColumnInfo(comment="酒店位置",type="varchar(200)")
		private String jiudianAddress;
		/**
		* 特色
		*/

		@ColumnInfo(comment="特色",type="varchar(200)")
		private String jiudianTese;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 房型
		*/
		@ColumnInfo(comment="房型",type="int(11)")
		private Integer jiudianTypes;
			/**
			* 房型的值
			*/
			@ColumnInfo(comment="房型的字典表值",type="varchar(200)")
			private String jiudianValue;
		/**
		* 剩余房间数
		*/

		@ColumnInfo(comment="剩余房间数",type="int(11)")
		private Integer jiudianKucunNumber;
		/**
		* 房间原价
		*/
		@ColumnInfo(comment="房间原价",type="decimal(10,2)")
		private Double jiudianOldMoney;
		/**
		* 现价/天
		*/
		@ColumnInfo(comment="现价/天",type="decimal(10,2)")
		private Double jiudianNewMoney;
		/**
		* 房间热度
		*/

		@ColumnInfo(comment="房间热度",type="int(11)")
		private Integer jiudianClicknum;
		/**
		* 房间介绍
		*/

		@ColumnInfo(comment="房间介绍",type="longtext")
		private String jiudianContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jiudianDelete;
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public JiudianCommentbackView() {

	}

	public JiudianCommentbackView(JiudianCommentbackEntity jiudianCommentbackEntity) {
		try {
			BeanUtils.copyProperties(this, jiudianCommentbackEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 酒店
		/**
		* 获取：酒店 的 商家
		*/
		public Integer getJiudianShangjiaId() {
			return jiudianShangjiaId;
		}
		/**
		* 设置：酒店 的 商家
		*/
		public void setJiudianShangjiaId(Integer jiudianShangjiaId) {
			this.jiudianShangjiaId = jiudianShangjiaId;
		}

		/**
		* 获取： 房间名称
		*/
		public String getJiudianName() {
			return jiudianName;
		}
		/**
		* 设置： 房间名称
		*/
		public void setJiudianName(String jiudianName) {
			this.jiudianName = jiudianName;
		}

		/**
		* 获取： 房间编号
		*/
		public String getJiudianUuidNumber() {
			return jiudianUuidNumber;
		}
		/**
		* 设置： 房间编号
		*/
		public void setJiudianUuidNumber(String jiudianUuidNumber) {
			this.jiudianUuidNumber = jiudianUuidNumber;
		}

		/**
		* 获取： 房间照片
		*/
		public String getJiudianPhoto() {
			return jiudianPhoto;
		}
		/**
		* 设置： 房间照片
		*/
		public void setJiudianPhoto(String jiudianPhoto) {
			this.jiudianPhoto = jiudianPhoto;
		}

		/**
		* 获取： 酒店位置
		*/
		public String getJiudianAddress() {
			return jiudianAddress;
		}
		/**
		* 设置： 酒店位置
		*/
		public void setJiudianAddress(String jiudianAddress) {
			this.jiudianAddress = jiudianAddress;
		}

		/**
		* 获取： 特色
		*/
		public String getJiudianTese() {
			return jiudianTese;
		}
		/**
		* 设置： 特色
		*/
		public void setJiudianTese(String jiudianTese) {
			this.jiudianTese = jiudianTese;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 房型
		*/
		public Integer getJiudianTypes() {
			return jiudianTypes;
		}
		/**
		* 设置： 房型
		*/
		public void setJiudianTypes(Integer jiudianTypes) {
			this.jiudianTypes = jiudianTypes;
		}


			/**
			* 获取： 房型的值
			*/
			public String getJiudianValue() {
				return jiudianValue;
			}
			/**
			* 设置： 房型的值
			*/
			public void setJiudianValue(String jiudianValue) {
				this.jiudianValue = jiudianValue;
			}

		/**
		* 获取： 剩余房间数
		*/
		public Integer getJiudianKucunNumber() {
			return jiudianKucunNumber;
		}
		/**
		* 设置： 剩余房间数
		*/
		public void setJiudianKucunNumber(Integer jiudianKucunNumber) {
			this.jiudianKucunNumber = jiudianKucunNumber;
		}

		/**
		* 获取： 房间原价
		*/
		public Double getJiudianOldMoney() {
			return jiudianOldMoney;
		}
		/**
		* 设置： 房间原价
		*/
		public void setJiudianOldMoney(Double jiudianOldMoney) {
			this.jiudianOldMoney = jiudianOldMoney;
		}

		/**
		* 获取： 现价/天
		*/
		public Double getJiudianNewMoney() {
			return jiudianNewMoney;
		}
		/**
		* 设置： 现价/天
		*/
		public void setJiudianNewMoney(Double jiudianNewMoney) {
			this.jiudianNewMoney = jiudianNewMoney;
		}

		/**
		* 获取： 房间热度
		*/
		public Integer getJiudianClicknum() {
			return jiudianClicknum;
		}
		/**
		* 设置： 房间热度
		*/
		public void setJiudianClicknum(Integer jiudianClicknum) {
			this.jiudianClicknum = jiudianClicknum;
		}

		/**
		* 获取： 房间介绍
		*/
		public String getJiudianContent() {
			return jiudianContent;
		}
		/**
		* 设置： 房间介绍
		*/
		public void setJiudianContent(String jiudianContent) {
			this.jiudianContent = jiudianContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJiudianDelete() {
			return jiudianDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJiudianDelete(Integer jiudianDelete) {
			this.jiudianDelete = jiudianDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "JiudianCommentbackView{" +
			", jiudianName=" + jiudianName +
			", jiudianUuidNumber=" + jiudianUuidNumber +
			", jiudianPhoto=" + jiudianPhoto +
			", jiudianAddress=" + jiudianAddress +
			", jiudianTese=" + jiudianTese +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", jiudianKucunNumber=" + jiudianKucunNumber +
			", jiudianOldMoney=" + jiudianOldMoney +
			", jiudianNewMoney=" + jiudianNewMoney +
			", jiudianClicknum=" + jiudianClicknum +
			", jiudianContent=" + jiudianContent +
			", jiudianDelete=" + jiudianDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
