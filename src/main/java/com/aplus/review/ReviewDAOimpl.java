package com.aplus.review;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAOimpl implements ReviewDAO{
	@Autowired SqlSession sql;
}