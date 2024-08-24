package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 停车缴费
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-23 23:12:44
 */
@TableName("tingchejiaofei")
public class TingchejiaofeiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TingchejiaofeiEntity() {
		
	}
	
	public TingchejiaofeiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 订单号
	 */
					
	private String dingdanhao;
	
	/**
	 * 停车场名称
	 */
					
	private String tingchechangmingcheng;
	
	/**
	 * 区域
	 */
					
	private String quyu;
	
	/**
	 * 小时单价
	 */
					
	private Integer xiaoshidanjia;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 车牌号
	 */
					
	private String chepaihao;
	
	/**
	 * 车辆图片
	 */
					
	private String cheliangtupian;
	
	/**
	 * 进场时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jinchangshijian;
	
	/**
	 * 离场时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date lichangshijian;
	
	/**
	 * 本次停车时长
	 */
					
	private Double bencitingcheshizhang;
	
	/**
	 * 停车费用
	 */
					
	private Double bencitingchefeiyong;
	
	/**
	 * 跨表用户id
	 */
					
	private Long crossuserid;
	
	/**
	 * 跨表主键id
	 */
					
	private Long crossrefid;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：订单号
	 */
	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}
	/**
	 * 获取：订单号
	 */
	public String getDingdanhao() {
		return dingdanhao;
	}
	/**
	 * 设置：停车场名称
	 */
	public void setTingchechangmingcheng(String tingchechangmingcheng) {
		this.tingchechangmingcheng = tingchechangmingcheng;
	}
	/**
	 * 获取：停车场名称
	 */
	public String getTingchechangmingcheng() {
		return tingchechangmingcheng;
	}
	/**
	 * 设置：区域
	 */
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	/**
	 * 获取：区域
	 */
	public String getQuyu() {
		return quyu;
	}
	/**
	 * 设置：小时单价
	 */
	public void setXiaoshidanjia(Integer xiaoshidanjia) {
		this.xiaoshidanjia = xiaoshidanjia;
	}
	/**
	 * 获取：小时单价
	 */
	public Integer getXiaoshidanjia() {
		return xiaoshidanjia;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：车牌号
	 */
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	/**
	 * 获取：车牌号
	 */
	public String getChepaihao() {
		return chepaihao;
	}
	/**
	 * 设置：车辆图片
	 */
	public void setCheliangtupian(String cheliangtupian) {
		this.cheliangtupian = cheliangtupian;
	}
	/**
	 * 获取：车辆图片
	 */
	public String getCheliangtupian() {
		return cheliangtupian;
	}
	/**
	 * 设置：进场时间
	 */
	public void setJinchangshijian(Date jinchangshijian) {
		this.jinchangshijian = jinchangshijian;
	}
	/**
	 * 获取：进场时间
	 */
	public Date getJinchangshijian() {
		return jinchangshijian;
	}
	/**
	 * 设置：离场时间
	 */
	public void setLichangshijian(Date lichangshijian) {
		this.lichangshijian = lichangshijian;
	}
	/**
	 * 获取：离场时间
	 */
	public Date getLichangshijian() {
		return lichangshijian;
	}
	/**
	 * 设置：本次停车时长
	 */
	public void setBencitingcheshizhang(Double bencitingcheshizhang) {
		this.bencitingcheshizhang = bencitingcheshizhang;
	}
	/**
	 * 获取：本次停车时长
	 */
	public Double getBencitingcheshizhang() {
		return bencitingcheshizhang;
	}
	/**
	 * 设置：停车费用
	 */
	public void setBencitingchefeiyong(Double bencitingchefeiyong) {
		this.bencitingchefeiyong = bencitingchefeiyong;
	}
	/**
	 * 获取：停车费用
	 */
	public Double getBencitingchefeiyong() {
		return bencitingchefeiyong;
	}
	/**
	 * 设置：跨表用户id
	 */
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
	/**
	 * 设置：跨表主键id
	 */
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
