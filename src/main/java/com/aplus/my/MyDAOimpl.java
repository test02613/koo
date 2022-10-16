package com.aplus.my;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyDAOimpl implements MyDAO{
	@Autowired SqlSession sql;
}
