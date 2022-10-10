package com.aplus.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceimpl implements ItemService{
	
	@Autowired ItemDAO dao;
	
	@Override
	public List<ItemVO> itemList(Integer cat) throws Exception {
		// TODO Auto-generated method stub
		return dao.itemList(cat);
	}


}
