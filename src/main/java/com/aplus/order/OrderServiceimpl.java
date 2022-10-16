package com.aplus.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplus.item.ItemAttrVO;
import com.aplus.model.MemberVO;


@Service
public class OrderServiceimpl implements OrderService {

	@Autowired OrderDAO dao;

	@Override
	public ItemAttrVO order_item(Integer code) throws Exception {
		// TODO Auto-generated method stub
		return dao.order_item(code);
	}

	@Override
	public MemberVO member(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.member(id);
	}

	@Override
	public void orderAction(OrderVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.orderAction(vo);
		
	}

	@Override
	public OrderVO orderFinish(Integer num) throws Exception {
		// TODO Auto-generated method stub
		return dao.orderFinish(num);
	}

	@Override
	public MemberVO point(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.point(vo);
	}
	
}
