package com.aplus.my;

import java.util.List;

import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;

public interface MyService {

	public MemberVO member(String id) throws Exception;
	
	public MemberVO update(MemberVO vo) throws Exception;
	
	public List<OrderVO> orderList(String id) throws Exception;
	
}
