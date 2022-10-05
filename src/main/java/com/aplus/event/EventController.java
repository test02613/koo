package com.aplus.event;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aplus.controller.MemberController;
import com.aplus.model.MemberVO;
@Controller
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String eventGET() {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 이벤트 페이지 진입");
		return "event/event";
	}
	
	@RequestMapping(value = "/eventCreate", method = RequestMethod.GET)
	public String evntcreateGET() {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 글쓰기 페이지 진입");
		return "event/eventCreate";
	}
	
	@RequestMapping(value = "/eventCreateAction", method = RequestMethod.GET)
	public String eventCreateActionGET() {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 글쓰기 페이지 진입");
		return "event/event";
	}
	
	

}
