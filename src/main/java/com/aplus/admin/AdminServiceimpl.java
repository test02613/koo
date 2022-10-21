package com.aplus.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplus.item.ItemAttrVO;
import com.aplus.item.ItemVO;


@Service
public class AdminServiceimpl implements AdminService {
	@Autowired AdminDAO dao;

	@Override
	public void iteminsertAction(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.iteminsertAction(vo);
	}

	@Override
	public List<ItemVO> itemselect(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.itemselect(vo);
	}

	@Override
	public ItemVO itemattr(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.itemattr(vo);
	}

	@Override
	public void itemattrAction(ItemAttrVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.itemattrAction(vo);
	}

	@Override
	public ItemVO itemupdateAction(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.itemupdateAction(vo);
	}

	@Override
	public ItemAttrVO attrupdate(ItemAttrVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.attrupdate(vo);
	}

	@Override
	public ItemAttrVO attrupdateAction(ItemAttrVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.attrupdateAction(vo);
	}
}
