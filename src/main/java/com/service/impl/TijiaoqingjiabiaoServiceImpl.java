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


import com.dao.TijiaoqingjiabiaoDao;
import com.entity.TijiaoqingjiabiaoEntity;
import com.service.TijiaoqingjiabiaoService;
import com.entity.vo.TijiaoqingjiabiaoVO;
import com.entity.view.TijiaoqingjiabiaoView;

@Service("tijiaoqingjiabiaoService")
public class TijiaoqingjiabiaoServiceImpl extends ServiceImpl<TijiaoqingjiabiaoDao, TijiaoqingjiabiaoEntity> implements TijiaoqingjiabiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TijiaoqingjiabiaoEntity> page = this.selectPage(
                new Query<TijiaoqingjiabiaoEntity>(params).getPage(),
                new EntityWrapper<TijiaoqingjiabiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TijiaoqingjiabiaoEntity> wrapper) {
		  Page<TijiaoqingjiabiaoView> page =new Query<TijiaoqingjiabiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TijiaoqingjiabiaoVO> selectListVO(Wrapper<TijiaoqingjiabiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TijiaoqingjiabiaoVO selectVO(Wrapper<TijiaoqingjiabiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TijiaoqingjiabiaoView> selectListView(Wrapper<TijiaoqingjiabiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TijiaoqingjiabiaoView selectView(Wrapper<TijiaoqingjiabiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
