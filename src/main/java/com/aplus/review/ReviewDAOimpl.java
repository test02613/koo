package com.aplus.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplus.order.OrderVO;

@Repository
public class ReviewDAOimpl implements ReviewDAO{
	@Autowired SqlSession sql;

	@Override
	public List<ReviewVO> reviewlist(Integer num) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.Review_SQL.review_list", num);
	}

	@Override
	public void reviewAction(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		 sql.insert("mapper.Review_SQL.review_Action", vo);
	}

	@Override
	public OrderVO orderreview(OrderVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Review_SQL.orderreview_up", vo);
	}

	@Override
	public ReviewVO reviewUp(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Review_SQL.review_up", vo);
	}

	@Override
	public ReviewVO reviewUpAction(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Review_SQL.review_upAction", vo);
	}
}
