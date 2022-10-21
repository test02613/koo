package com.aplus.my;

import java.util.List;

import com.aplus.event.EventVO;
import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;
import com.aplus.review.ReviewVO;

public interface MyDAO {

	public MemberVO member(String id) throws Exception;

	public MemberVO update(MemberVO vo) throws Exception;
	
	public List<OrderVO> orderList(String id) throws Exception;
	
	public  List<ReviewVO> myreview(String id) throws Exception;
	
	public MemberVO pointAction(MemberVO vo) throws Exception;
}
