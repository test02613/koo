package com.aplus.review;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplus.controller.MemberController;
import com.aplus.item.ItemVO;


@Controller
public class ReviewController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private ReviewService reviewservice;
	
	
	@RequestMapping(value = "/reviewCreate", method = RequestMethod.GET)
	public String reviewCreateGET(ReviewVO vo,Model model,HttpSession session,Integer order,Integer item) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 리뷰작성 페이지 진입");
		model.addAttribute("item", item);
		model.addAttribute("order", order);
		return "review/reviewCreate";
	}

	@RequestMapping(value = "/reviewCreateAction", method = RequestMethod.POST)
	public String reviewCreateActionGET(ReviewVO vo,Model model,HttpSession session) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 리뷰작성  실행 진입");
		String id = (String) session.getAttribute("id");//세션 id가져오기
		vo.setId(id);
		
		reviewservice.reviewAction(vo);
		
		return "redirect:/myorder";
	}
}
