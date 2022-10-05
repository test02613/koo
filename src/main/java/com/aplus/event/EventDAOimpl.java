package com.aplus.event;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EventDAOimpl implements EventDAO{
	@Autowired SqlSession sql;
	
	@Override
	public void eventCreate(EventVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert("mapper.Event_SQL.event_insert",vo);
	}

}
