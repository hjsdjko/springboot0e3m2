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


import com.dao.QingjiabiaogeDao;
import com.entity.QingjiabiaogeEntity;
import com.service.QingjiabiaogeService;
import com.entity.vo.QingjiabiaogeVO;
import com.entity.view.QingjiabiaogeView;

@Service("qingjiabiaogeService")
public class QingjiabiaogeServiceImpl extends ServiceImpl<QingjiabiaogeDao, QingjiabiaogeEntity> implements QingjiabiaogeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QingjiabiaogeEntity> page = this.selectPage(
                new Query<QingjiabiaogeEntity>(params).getPage(),
                new EntityWrapper<QingjiabiaogeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QingjiabiaogeEntity> wrapper) {
		  Page<QingjiabiaogeView> page =new Query<QingjiabiaogeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QingjiabiaogeVO> selectListVO(Wrapper<QingjiabiaogeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QingjiabiaogeVO selectVO(Wrapper<QingjiabiaogeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QingjiabiaogeView> selectListView(Wrapper<QingjiabiaogeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QingjiabiaogeView selectView(Wrapper<QingjiabiaogeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
