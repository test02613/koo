package com.aplus.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceimpl implements EventService{
	
	@Autowired EventDAO dao;
	
	@Override
	public void eventCreate(EventVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.eventCreate(vo);
	}

}
