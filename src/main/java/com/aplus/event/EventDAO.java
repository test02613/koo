package com.aplus.event;

import java.util.List;
import com.aplus.model.MemberVO;

public interface EventDAO {
	
	public void eventCreate(EventVO vo) throws Exception;
	
	public List<EventVO> list() throws Exception;

	/*public List<EventVO> eventVOList(EventVO vo);*/
	public EventVO eventDetail(Integer num) throws Exception;

	public EventVO eventUpdate(EventVO vo) throws Exception;
}
