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


import com.dao.QuekejiluDao;
import com.entity.QuekejiluEntity;
import com.service.QuekejiluService;
import com.entity.vo.QuekejiluVO;
import com.entity.view.QuekejiluView;

@Service("quekejiluService")
public class QuekejiluServiceImpl extends ServiceImpl<QuekejiluDao, QuekejiluEntity> implements QuekejiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuekejiluEntity> page = this.selectPage(
                new Query<QuekejiluEntity>(params).getPage(),
                new EntityWrapper<QuekejiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QuekejiluEntity> wrapper) {
		  Page<QuekejiluView> page =new Query<QuekejiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QuekejiluVO> selectListVO(Wrapper<QuekejiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QuekejiluVO selectVO(Wrapper<QuekejiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QuekejiluView> selectListView(Wrapper<QuekejiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuekejiluView selectView(Wrapper<QuekejiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
