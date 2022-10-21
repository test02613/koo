package com.aplus.my;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;
import com.aplus.review.ReviewVO;


@Service
public class MyServiceimpl implements MyService{
	@Autowired MyDAO dao;

	@Override
	public MemberVO member(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.member(id);
	}

	@Override
	public MemberVO update(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(vo);
	}

	@Override
	public List<OrderVO> orderList(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.orderList(id);
	}

	@Override
	public List<ReviewVO> myreview(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.myreview(id);
	}

	@Override
	public MemberVO pointAction(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.pointAction(vo);
	}
}
