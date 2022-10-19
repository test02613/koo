package com.aplus.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
