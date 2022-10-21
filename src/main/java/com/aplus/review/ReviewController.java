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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aplus.controller.MemberController;
import com.aplus.item.ItemAttrVO;
import com.aplus.item.ItemVO;
import com.aplus.order.OrderVO;


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
	public String reviewCreateActionGET(ReviewVO vo,Model model,HttpSession session,Integer order) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 리뷰작성  실행 진입");
		String id = (String) session.getAttribute("id");//세션 id가져오기
		vo.setId(id);
		model.addAttribute("order", order);
		reviewservice.reviewAction(vo);
		
		return "redirect:/myorder";
	}
	
	@RequestMapping(value = "/orderreview", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public void orderreviewGET(OrderVO vo, Model model,@RequestParam("num") String num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  진입");
		int to =Integer.parseInt(num);
		vo.setOrdernum(to);
		reviewservice.orderreview(vo);
		
	}
	
	@RequestMapping(value = "/reviewUpdate", method = RequestMethod.GET)
	public String reviewUpdateGET(ReviewVO vo,Model model,HttpSession session,Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 리뷰작성 페이지 진입");
		vo.setReviewnum(num);
		vo = reviewservice.reviewUp(vo);
		model.addAttribute("list", vo);
		
		return "review/reviewCreate";
	}

	@RequestMapping(value = "/reviewUpdateAction", method = RequestMethod.POST)
	public String reviewUpdateActionGET(ReviewVO vo,Model model,HttpSession session,Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 리뷰작성 페이지 진입");
		vo.setReviewnum(num);
		vo = reviewservice.reviewUpAction(vo);
		model.addAttribute("list", vo);
		
		return "redirect:/myreview";
	}
	
	
}
