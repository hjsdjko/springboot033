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
 * 车位信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-23 23:12:44
 */
@TableName("cheweixinxi")
public class CheweixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CheweixinxiEntity() {
		
	}
	
	public CheweixinxiEntity(T t) {
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
	 * 停车场名称
	 */
					
	private String tingchechangmingcheng;
	
	/**
	 * 区域
	 */
					
	private String quyu;
	
	/**
	 * 车位图片
	 */
					
	private String cheweitupian;
	
	/**
	 * 车位数量
	 */
					
	private Integer cheweishuliang;
	
	/**
	 * 小时单价
	 */
					
	private Integer xiaoshidanjia;
	
	/**
	 * 车位详情
	 */
					
	private String cheweixiangqing;
	
	
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
	 * 设置：车位图片
	 */
	public void setCheweitupian(String cheweitupian) {
		this.cheweitupian = cheweitupian;
	}
	/**
	 * 获取：车位图片
	 */
	public String getCheweitupian() {
		return cheweitupian;
	}
	/**
	 * 设置：车位数量
	 */
	public void setCheweishuliang(Integer cheweishuliang) {
		this.cheweishuliang = cheweishuliang;
	}
	/**
	 * 获取：车位数量
	 */
	public Integer getCheweishuliang() {
		return cheweishuliang;
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
	 * 设置：车位详情
	 */
	public void setCheweixiangqing(String cheweixiangqing) {
		this.cheweixiangqing = cheweixiangqing;
	}
	/**
	 * 获取：车位详情
	 */
	public String getCheweixiangqing() {
		return cheweixiangqing;
	}

}
