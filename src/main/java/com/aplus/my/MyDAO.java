package com.aplus.my;

import java.util.List;

import com.aplus.event.EventVO;
import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;

public interface MyDAO {

	public MemberVO member(String id) throws Exception;

	public MemberVO update(MemberVO vo) throws Exception;
	
	public List<OrderVO> orderList(String id) throws Exception;
}
