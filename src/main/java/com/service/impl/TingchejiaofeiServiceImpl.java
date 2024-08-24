package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TingchejiaofeiDao;
import com.entity.TingchejiaofeiEntity;
import com.service.TingchejiaofeiService;
import com.entity.vo.TingchejiaofeiVO;
import com.entity.view.TingchejiaofeiView;

@Service("tingchejiaofeiService")
public class TingchejiaofeiServiceImpl extends ServiceImpl<TingchejiaofeiDao, TingchejiaofeiEntity> implements TingchejiaofeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TingchejiaofeiEntity> page = this.selectPage(
                new Query<TingchejiaofeiEntity>(params).getPage(),
                new EntityWrapper<TingchejiaofeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TingchejiaofeiEntity> wrapper) {
		  Page<TingchejiaofeiView> page =new Query<TingchejiaofeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TingchejiaofeiVO> selectListVO(Wrapper<TingchejiaofeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TingchejiaofeiVO selectVO(Wrapper<TingchejiaofeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TingchejiaofeiView> selectListView(Wrapper<TingchejiaofeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TingchejiaofeiView selectView(Wrapper<TingchejiaofeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<TingchejiaofeiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<TingchejiaofeiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<TingchejiaofeiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
