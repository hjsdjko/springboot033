package com.entity.view;

import com.entity.TingchejiaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 停车缴费
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-23 23:12:44
 */
@TableName("tingchejiaofei")
public class TingchejiaofeiView  extends TingchejiaofeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TingchejiaofeiView(){
	}
 
 	public TingchejiaofeiView(TingchejiaofeiEntity tingchejiaofeiEntity){
 	try {
			BeanUtils.copyProperties(this, tingchejiaofeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
