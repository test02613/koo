package com.aplus.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceimpl implements ItemService{
	
	@Autowired ItemDAO dao;
	
	@Override
	public List<ItemVO> itemListL(Integer cat) throws Exception {
		// TODO Auto-generated method stub
		return dao.itemListL(cat);
	}
	
	@Override
	public List<ItemVO> itemList(Integer cat) throws Exception {
		// TODO Auto-generated method stub
		return dao.itemList(cat);
	}

	@Override
	public ItemVO itemDetail(Integer num) throws Exception {
		// TODO Auto-generated method stub
		return dao.itemDetail(num);
	}

	@Override
	public List<ItemAttrVO> itemAttr(Integer num) throws Exception {
		// TODO Auto-generated method stub
		return dao.itemAttr(num);
	}

	@Override
	public ItemAttrVO colorChk(ItemAttrVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.colorChk(vo);
	}


}
