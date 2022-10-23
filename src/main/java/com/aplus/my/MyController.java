package com.aplus.my;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplus.controller.MemberController;
import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;
import com.aplus.review.ReviewVO;
import com.aplus.service.MemberService;

@Controller
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MyService myservice;
	
	@RequestMapping(value = "/mymain", method = RequestMethod.GET)
	public String mymainGET(MemberVO vo,HttpSession session,Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 마이 페이지 진입");
		String id = (String) session.getAttribute("id");//세션 id가져오기
		vo.setId(id);
		vo = myservice.member(id);
		model.addAttribute("member", vo);
		return "my/myMain";
	}

	@RequestMapping(value = "/myupdate", method = {RequestMethod.GET,RequestMethod.POST})
	public String myupdateGET(MemberVO vo,HttpSession session,Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 정보수정 페이지 진입");
		String id = (String) session.getAttribute("id");//세션 id가져오기
		vo.setId(id);
		vo = myservice.member(id);
		model.addAttribute("member", vo);
		
		return "my/myUpdate";
	}
	
	@RequestMapping(value = "/myupdateAction", method = {RequestMethod.GET,RequestMethod.POST})
	public String myupdateActionGET(MemberVO vo,HttpSession session,Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 정보수정 진행 페이지 진입");
		String id = (String) session.getAttribute("id");//세션 id가져오기
		vo.setId(id);
		
		myservice.update(vo);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/memberleave", method = {RequestMethod.GET,RequestMethod.POST})
	public String memberleaveGET(MemberVO vo,HttpSession session,Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 정보수정 진행 페이지 진입");
		String id = (String) session.getAttribute("id");//세션 id가져오기
		vo.setId(id);
		
		myservice.memberleave(vo);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/myorder", method = {RequestMethod.GET,RequestMethod.POST})
	public String myorderGET(HttpSession session,Model model,OrderVO vo) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 주문조회 페이지 진입");
		String id = (String) session.getAttribute("id");//세션 id가져오기
		vo.setId(id);
		List<OrderVO> list =myservice.orderList(id);
		logger.info("ddddd"+list);
		model.addAttribute("order", list);
		return "my/myOrder";
	}
	@RequestMapping(value = "/mypoint", method = {RequestMethod.GET,RequestMethod.POST})
	public String mypointGET(HttpSession session,Model model , MemberVO vo)  throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 포인트 조회 페이지 진입");
		String id = (String) session.getAttribute("id");
		vo.setId(id);
		vo = myservice.member(id);
		model.addAttribute("member", vo);
		
		return "my/myPoint";
	}
	@RequestMapping(value = "/mypointAction", method = {RequestMethod.GET,RequestMethod.POST})
	public String mypointActionGET(MemberVO vo,HttpSession session,Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 정보수정 진행 페이지 진입");
		String id = (String) session.getAttribute("id");
		vo = myservice.member(id);
		Integer point = vo.getPoint();
		myservice.pointAction(vo);
		Integer getpoint = vo.getPoint();
		Integer to=point+getpoint;
		vo.setPoint(to);
		myservice.pointAction(vo);
		return "redirect:/mymain";
	}
	
	@RequestMapping(value = "/myreview", method = {RequestMethod.GET,RequestMethod.POST})
	public String myreviewGET(HttpSession session,Model model , ReviewVO vo) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 리뷰관리 페이지 진입");
		String id = (String) session.getAttribute("id");//세션 id가져오기
		List<ReviewVO> list=myservice.myreview(id);
		model.addAttribute("review", list);
		return "my/myReview";
	}
	@RequestMapping(value = "/myqna", method = {RequestMethod.GET,RequestMethod.POST})
	public String myqnaGET() {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 큐엔에이 페이지 진입");
		return "my/myqna";
	}
}
