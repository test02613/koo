package com.aplus.my;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;
import com.aplus.review.ReviewVO;

@Repository
public class MyDAOimpl implements MyDAO{
	@Autowired SqlSession sql;

	@Override
	public MemberVO member(String id) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Order_SQL.order_member", id);
	}

	@Override
	public MemberVO update(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.My_SQL.member_Update", vo);
	}

	@Override
	public List<OrderVO> orderList(String id) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.My_SQL.order_list",id);
	}

	@Override
	public List<ReviewVO> myreview(String id) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.My_SQL.review_list",id);
	}

	@Override
	public MemberVO pointAction(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.My_SQL.pointAction", vo);
	}

	@Override
	public MemberVO memberleave(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.My_SQL.member_leave",vo);
	}
}
