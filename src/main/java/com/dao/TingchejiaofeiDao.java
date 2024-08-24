package com.dao;

import com.entity.TingchejiaofeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TingchejiaofeiVO;
import com.entity.view.TingchejiaofeiView;


/**
 * 停车缴费
 * 
 * @author 
 * @email 
 * @date 2024-04-23 23:12:44
 */
public interface TingchejiaofeiDao extends BaseMapper<TingchejiaofeiEntity> {
	
	List<TingchejiaofeiVO> selectListVO(@Param("ew") Wrapper<TingchejiaofeiEntity> wrapper);
	
	TingchejiaofeiVO selectVO(@Param("ew") Wrapper<TingchejiaofeiEntity> wrapper);
	
	List<TingchejiaofeiView> selectListView(@Param("ew") Wrapper<TingchejiaofeiEntity> wrapper);

	List<TingchejiaofeiView> selectListView(Pagination page,@Param("ew") Wrapper<TingchejiaofeiEntity> wrapper);

	
	TingchejiaofeiView selectView(@Param("ew") Wrapper<TingchejiaofeiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TingchejiaofeiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TingchejiaofeiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TingchejiaofeiEntity> wrapper);



}
