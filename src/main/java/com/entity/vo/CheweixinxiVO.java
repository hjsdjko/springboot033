package com.entity.vo;

import com.entity.CheweixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 车位信息
 * @author 
 * @email 
 * @date 2024-04-23 23:12:44
 */
public class CheweixinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
