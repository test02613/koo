package com.aplus.review;

import java.util.List;

import com.aplus.order.OrderVO;


public interface ReviewDAO {
	
	public List<ReviewVO> reviewlist(Integer num) throws Exception;
	
	public void reviewAction(ReviewVO vo) throws Exception;
	
	public OrderVO orderreview(OrderVO vo) throws Exception;
	
	public ReviewVO reviewUp(ReviewVO vo) throws Exception;

	public ReviewVO reviewUpAction(ReviewVO vo) throws Exception;

}
