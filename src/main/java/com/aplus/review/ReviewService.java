package com.aplus.review;

import java.util.List;

public interface ReviewService {
	
	public List<ReviewVO> reviewlist(Integer num) throws Exception;
	
	public void reviewAction(ReviewVO vo) throws Exception;

}
