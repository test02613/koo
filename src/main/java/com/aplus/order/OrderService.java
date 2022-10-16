package com.aplus.order;

import com.aplus.item.ItemAttrVO;
import com.aplus.model.MemberVO;

public interface OrderService {

	
	public ItemAttrVO order_item(Integer code) throws Exception;
	
	public MemberVO member(String id) throws Exception;
	
	public void orderAction(OrderVO vo) throws Exception;
	
	public OrderVO orderFinish(Integer num) throws Exception;
	
	public MemberVO point(MemberVO vo) throws Exception;

}
