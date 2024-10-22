package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.MeishiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 美食订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("meishi_order")
public class MeishiOrderView extends MeishiOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String meishiOrderValue;
	/**
	* 支付类型的值
	*/
	@ColumnInfo(comment="支付类型的字典表值",type="varchar(200)")
	private String meishiOrderPaymentValue;

	//级联表 收货地址
					 
		/**
		* 收货地址 的 创建用户
		*/
		@ColumnInfo(comment="创建用户",type="int(20)")
		private Integer addressYonghuId;
		/**
		* 收货人
		*/

		@ColumnInfo(comment="收货人",type="varchar(200)")
		private String addressName;
		/**
		* 电话
		*/

		@ColumnInfo(comment="电话",type="varchar(200)")
		private String addressPhone;
		/**
		* 地址
		*/

		@ColumnInfo(comment="地址",type="varchar(200)")
		private String addressDizhi;
		/**
		* 是否默认地址
		*/
		@ColumnInfo(comment="是否默认地址",type="int(11)")
		private Integer isdefaultTypes;
			/**
			* 是否默认地址的值
			*/
			@ColumnInfo(comment="是否默认地址的字典表值",type="varchar(200)")
			private String isdefaultValue;
	//级联表 美食
					 
		/**
		* 美食 的 商家
		*/
		@ColumnInfo(comment="商家",type="int(11)")
		private Integer meishiShangjiaId;
		/**
		* 美食名称
		*/

		@ColumnInfo(comment="美食名称",type="varchar(200)")
		private String meishiName;
		/**
		* 美食编号
		*/

		@ColumnInfo(comment="美食编号",type="varchar(200)")
		private String meishiUuidNumber;
		/**
		* 美食照片
		*/

		@ColumnInfo(comment="美食照片",type="varchar(200)")
		private String meishiPhoto;
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
		* 美食类型
		*/
		@ColumnInfo(comment="美食类型",type="int(11)")
		private Integer meishiTypes;
			/**
			* 美食类型的值
			*/
			@ColumnInfo(comment="美食类型的字典表值",type="varchar(200)")
			private String meishiValue;
		/**
		* 美食库存
		*/

		@ColumnInfo(comment="美食库存",type="int(11)")
		private Integer meishiKucunNumber;
		/**
		* 美食原价
		*/
		@ColumnInfo(comment="美食原价",type="decimal(10,2)")
		private Double meishiOldMoney;
		/**
		* 现价/份
		*/
		@ColumnInfo(comment="现价/份",type="decimal(10,2)")
		private Double meishiNewMoney;
		/**
		* 美食热度
		*/

		@ColumnInfo(comment="美食热度",type="int(11)")
		private Integer meishiClicknum;
		/**
		* 美食介绍
		*/

		@ColumnInfo(comment="美食介绍",type="longtext")
		private String meishiContent;
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
		private Integer meishiDelete;
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



	public MeishiOrderView() {

	}

	public MeishiOrderView(MeishiOrderEntity meishiOrderEntity) {
		try {
			BeanUtils.copyProperties(this, meishiOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getMeishiOrderValue() {
		return meishiOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setMeishiOrderValue(String meishiOrderValue) {
		this.meishiOrderValue = meishiOrderValue;
	}
	//当前表的
	/**
	* 获取： 支付类型的值
	*/
	public String getMeishiOrderPaymentValue() {
		return meishiOrderPaymentValue;
	}
	/**
	* 设置： 支付类型的值
	*/
	public void setMeishiOrderPaymentValue(String meishiOrderPaymentValue) {
		this.meishiOrderPaymentValue = meishiOrderPaymentValue;
	}


	//级联表的get和set 收货地址
		/**
		* 获取：收货地址 的 创建用户
		*/
		public Integer getAddressYonghuId() {
			return addressYonghuId;
		}
		/**
		* 设置：收货地址 的 创建用户
		*/
		public void setAddressYonghuId(Integer addressYonghuId) {
			this.addressYonghuId = addressYonghuId;
		}

		/**
		* 获取： 收货人
		*/
		public String getAddressName() {
			return addressName;
		}
		/**
		* 设置： 收货人
		*/
		public void setAddressName(String addressName) {
			this.addressName = addressName;
		}

		/**
		* 获取： 电话
		*/
		public String getAddressPhone() {
			return addressPhone;
		}
		/**
		* 设置： 电话
		*/
		public void setAddressPhone(String addressPhone) {
			this.addressPhone = addressPhone;
		}

		/**
		* 获取： 地址
		*/
		public String getAddressDizhi() {
			return addressDizhi;
		}
		/**
		* 设置： 地址
		*/
		public void setAddressDizhi(String addressDizhi) {
			this.addressDizhi = addressDizhi;
		}
		/**
		* 获取： 是否默认地址
		*/
		public Integer getIsdefaultTypes() {
			return isdefaultTypes;
		}
		/**
		* 设置： 是否默认地址
		*/
		public void setIsdefaultTypes(Integer isdefaultTypes) {
			this.isdefaultTypes = isdefaultTypes;
		}


			/**
			* 获取： 是否默认地址的值
			*/
			public String getIsdefaultValue() {
				return isdefaultValue;
			}
			/**
			* 设置： 是否默认地址的值
			*/
			public void setIsdefaultValue(String isdefaultValue) {
				this.isdefaultValue = isdefaultValue;
			}
	//级联表的get和set 美食
		/**
		* 获取：美食 的 商家
		*/
		public Integer getMeishiShangjiaId() {
			return meishiShangjiaId;
		}
		/**
		* 设置：美食 的 商家
		*/
		public void setMeishiShangjiaId(Integer meishiShangjiaId) {
			this.meishiShangjiaId = meishiShangjiaId;
		}

		/**
		* 获取： 美食名称
		*/
		public String getMeishiName() {
			return meishiName;
		}
		/**
		* 设置： 美食名称
		*/
		public void setMeishiName(String meishiName) {
			this.meishiName = meishiName;
		}

		/**
		* 获取： 美食编号
		*/
		public String getMeishiUuidNumber() {
			return meishiUuidNumber;
		}
		/**
		* 设置： 美食编号
		*/
		public void setMeishiUuidNumber(String meishiUuidNumber) {
			this.meishiUuidNumber = meishiUuidNumber;
		}

		/**
		* 获取： 美食照片
		*/
		public String getMeishiPhoto() {
			return meishiPhoto;
		}
		/**
		* 设置： 美食照片
		*/
		public void setMeishiPhoto(String meishiPhoto) {
			this.meishiPhoto = meishiPhoto;
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
		* 获取： 美食类型
		*/
		public Integer getMeishiTypes() {
			return meishiTypes;
		}
		/**
		* 设置： 美食类型
		*/
		public void setMeishiTypes(Integer meishiTypes) {
			this.meishiTypes = meishiTypes;
		}


			/**
			* 获取： 美食类型的值
			*/
			public String getMeishiValue() {
				return meishiValue;
			}
			/**
			* 设置： 美食类型的值
			*/
			public void setMeishiValue(String meishiValue) {
				this.meishiValue = meishiValue;
			}

		/**
		* 获取： 美食库存
		*/
		public Integer getMeishiKucunNumber() {
			return meishiKucunNumber;
		}
		/**
		* 设置： 美食库存
		*/
		public void setMeishiKucunNumber(Integer meishiKucunNumber) {
			this.meishiKucunNumber = meishiKucunNumber;
		}

		/**
		* 获取： 美食原价
		*/
		public Double getMeishiOldMoney() {
			return meishiOldMoney;
		}
		/**
		* 设置： 美食原价
		*/
		public void setMeishiOldMoney(Double meishiOldMoney) {
			this.meishiOldMoney = meishiOldMoney;
		}

		/**
		* 获取： 现价/份
		*/
		public Double getMeishiNewMoney() {
			return meishiNewMoney;
		}
		/**
		* 设置： 现价/份
		*/
		public void setMeishiNewMoney(Double meishiNewMoney) {
			this.meishiNewMoney = meishiNewMoney;
		}

		/**
		* 获取： 美食热度
		*/
		public Integer getMeishiClicknum() {
			return meishiClicknum;
		}
		/**
		* 设置： 美食热度
		*/
		public void setMeishiClicknum(Integer meishiClicknum) {
			this.meishiClicknum = meishiClicknum;
		}

		/**
		* 获取： 美食介绍
		*/
		public String getMeishiContent() {
			return meishiContent;
		}
		/**
		* 设置： 美食介绍
		*/
		public void setMeishiContent(String meishiContent) {
			this.meishiContent = meishiContent;
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
		public Integer getMeishiDelete() {
			return meishiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setMeishiDelete(Integer meishiDelete) {
			this.meishiDelete = meishiDelete;
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
		return "MeishiOrderView{" +
			", meishiOrderValue=" + meishiOrderValue +
			", meishiOrderPaymentValue=" + meishiOrderPaymentValue +
			", addressName=" + addressName +
			", addressPhone=" + addressPhone +
			", addressDizhi=" + addressDizhi +
			", meishiName=" + meishiName +
			", meishiUuidNumber=" + meishiUuidNumber +
			", meishiPhoto=" + meishiPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", meishiKucunNumber=" + meishiKucunNumber +
			", meishiOldMoney=" + meishiOldMoney +
			", meishiNewMoney=" + meishiNewMoney +
			", meishiClicknum=" + meishiClicknum +
			", meishiContent=" + meishiContent +
			", meishiDelete=" + meishiDelete +
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
