package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JingdianCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 景点收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jingdian_collection")
public class JingdianCollectionView extends JingdianCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String jingdianCollectionValue;

	//级联表 景点
					 
		/**
		* 景点 的 商家
		*/
		@ColumnInfo(comment="商家",type="int(11)")
		private Integer jingdianShangjiaId;
		/**
		* 景点名称
		*/

		@ColumnInfo(comment="景点名称",type="varchar(200)")
		private String jingdianName;
		/**
		* 景点编号
		*/

		@ColumnInfo(comment="景点编号",type="varchar(200)")
		private String jingdianUuidNumber;
		/**
		* 景点照片
		*/

		@ColumnInfo(comment="景点照片",type="varchar(200)")
		private String jingdianPhoto;
		/**
		* 视频介绍
		*/

		@ColumnInfo(comment="视频介绍",type="varchar(200)")
		private String jingdianVideo;
		/**
		* 景点位置
		*/

		@ColumnInfo(comment="景点位置",type="varchar(200)")
		private String jingdianAddress;
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
		* 景点类型
		*/
		@ColumnInfo(comment="景点类型",type="int(11)")
		private Integer jingdianTypes;
			/**
			* 景点类型的值
			*/
			@ColumnInfo(comment="景点类型的字典表值",type="varchar(200)")
			private String jingdianValue;
		/**
		* 剩余门票数
		*/

		@ColumnInfo(comment="剩余门票数",type="int(11)")
		private Integer jingdianKucunNumber;
		/**
		* 景点原价
		*/
		@ColumnInfo(comment="景点原价",type="decimal(10,2)")
		private Double jingdianOldMoney;
		/**
		* 现价/张
		*/
		@ColumnInfo(comment="现价/张",type="decimal(10,2)")
		private Double jingdianNewMoney;
		/**
		* 景点热度
		*/

		@ColumnInfo(comment="景点热度",type="int(11)")
		private Integer jingdianClicknum;
		/**
		* 景点介绍
		*/

		@ColumnInfo(comment="景点介绍",type="longtext")
		private String jingdianContent;
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
		private Integer jingdianDelete;
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



	public JingdianCollectionView() {

	}

	public JingdianCollectionView(JingdianCollectionEntity jingdianCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, jingdianCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getJingdianCollectionValue() {
		return jingdianCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setJingdianCollectionValue(String jingdianCollectionValue) {
		this.jingdianCollectionValue = jingdianCollectionValue;
	}


	//级联表的get和set 景点
		/**
		* 获取：景点 的 商家
		*/
		public Integer getJingdianShangjiaId() {
			return jingdianShangjiaId;
		}
		/**
		* 设置：景点 的 商家
		*/
		public void setJingdianShangjiaId(Integer jingdianShangjiaId) {
			this.jingdianShangjiaId = jingdianShangjiaId;
		}

		/**
		* 获取： 景点名称
		*/
		public String getJingdianName() {
			return jingdianName;
		}
		/**
		* 设置： 景点名称
		*/
		public void setJingdianName(String jingdianName) {
			this.jingdianName = jingdianName;
		}

		/**
		* 获取： 景点编号
		*/
		public String getJingdianUuidNumber() {
			return jingdianUuidNumber;
		}
		/**
		* 设置： 景点编号
		*/
		public void setJingdianUuidNumber(String jingdianUuidNumber) {
			this.jingdianUuidNumber = jingdianUuidNumber;
		}

		/**
		* 获取： 景点照片
		*/
		public String getJingdianPhoto() {
			return jingdianPhoto;
		}
		/**
		* 设置： 景点照片
		*/
		public void setJingdianPhoto(String jingdianPhoto) {
			this.jingdianPhoto = jingdianPhoto;
		}

		/**
		* 获取： 视频介绍
		*/
		public String getJingdianVideo() {
			return jingdianVideo;
		}
		/**
		* 设置： 视频介绍
		*/
		public void setJingdianVideo(String jingdianVideo) {
			this.jingdianVideo = jingdianVideo;
		}

		/**
		* 获取： 景点位置
		*/
		public String getJingdianAddress() {
			return jingdianAddress;
		}
		/**
		* 设置： 景点位置
		*/
		public void setJingdianAddress(String jingdianAddress) {
			this.jingdianAddress = jingdianAddress;
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
		* 获取： 景点类型
		*/
		public Integer getJingdianTypes() {
			return jingdianTypes;
		}
		/**
		* 设置： 景点类型
		*/
		public void setJingdianTypes(Integer jingdianTypes) {
			this.jingdianTypes = jingdianTypes;
		}


			/**
			* 获取： 景点类型的值
			*/
			public String getJingdianValue() {
				return jingdianValue;
			}
			/**
			* 设置： 景点类型的值
			*/
			public void setJingdianValue(String jingdianValue) {
				this.jingdianValue = jingdianValue;
			}

		/**
		* 获取： 剩余门票数
		*/
		public Integer getJingdianKucunNumber() {
			return jingdianKucunNumber;
		}
		/**
		* 设置： 剩余门票数
		*/
		public void setJingdianKucunNumber(Integer jingdianKucunNumber) {
			this.jingdianKucunNumber = jingdianKucunNumber;
		}

		/**
		* 获取： 景点原价
		*/
		public Double getJingdianOldMoney() {
			return jingdianOldMoney;
		}
		/**
		* 设置： 景点原价
		*/
		public void setJingdianOldMoney(Double jingdianOldMoney) {
			this.jingdianOldMoney = jingdianOldMoney;
		}

		/**
		* 获取： 现价/张
		*/
		public Double getJingdianNewMoney() {
			return jingdianNewMoney;
		}
		/**
		* 设置： 现价/张
		*/
		public void setJingdianNewMoney(Double jingdianNewMoney) {
			this.jingdianNewMoney = jingdianNewMoney;
		}

		/**
		* 获取： 景点热度
		*/
		public Integer getJingdianClicknum() {
			return jingdianClicknum;
		}
		/**
		* 设置： 景点热度
		*/
		public void setJingdianClicknum(Integer jingdianClicknum) {
			this.jingdianClicknum = jingdianClicknum;
		}

		/**
		* 获取： 景点介绍
		*/
		public String getJingdianContent() {
			return jingdianContent;
		}
		/**
		* 设置： 景点介绍
		*/
		public void setJingdianContent(String jingdianContent) {
			this.jingdianContent = jingdianContent;
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
		public Integer getJingdianDelete() {
			return jingdianDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJingdianDelete(Integer jingdianDelete) {
			this.jingdianDelete = jingdianDelete;
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
		return "JingdianCollectionView{" +
			", jingdianCollectionValue=" + jingdianCollectionValue +
			", jingdianName=" + jingdianName +
			", jingdianUuidNumber=" + jingdianUuidNumber +
			", jingdianPhoto=" + jingdianPhoto +
			", jingdianVideo=" + jingdianVideo +
			", jingdianAddress=" + jingdianAddress +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", jingdianKucunNumber=" + jingdianKucunNumber +
			", jingdianOldMoney=" + jingdianOldMoney +
			", jingdianNewMoney=" + jingdianNewMoney +
			", jingdianClicknum=" + jingdianClicknum +
			", jingdianContent=" + jingdianContent +
			", jingdianDelete=" + jingdianDelete +
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
