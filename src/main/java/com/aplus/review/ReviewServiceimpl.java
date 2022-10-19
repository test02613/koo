package com.aplus.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewServiceimpl implements ReviewService{
	@Autowired ReviewDAO dao;

	@Override
	public List<ReviewVO> reviewlist(Integer num) throws Exception {
		// TODO Auto-generated method stub
		return dao.reviewlist(num);
	}

	@Override
	public void reviewAction(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		 dao.reviewAction(vo);
	}
}
