package com.aplus.event;

import java.util.List;

import org.springframework.stereotype.Service;


public interface EventService {
	
	//이벤트 글쓰기
	public void eventCreate(EventVO vo) throws Exception;
	//이벤트 목록
	public List<EventVO> list()  throws Exception;
	//이벤트 상세페이지
	public EventVO eventDetail(Integer num) throws Exception;
	
	public EventVO eventUpdate(EventVO vo) throws Exception;
}
