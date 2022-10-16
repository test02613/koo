package com.aplus.order;

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

import com.aplus.item.ItemAttrVO;
import com.aplus.item.ItemController;
import com.aplus.item.ItemVO;
import com.aplus.model.MemberVO;

@Controller
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	@Autowired
	private OrderService orderservice;
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String orderLGET(Model model,Integer code,HttpSession session,MemberVO mem) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 주문 페이지 진입");
		ItemAttrVO vo =orderservice.order_item(code);//item 정보 가져오기
		model.addAttribute("item",vo);
		String id = (String) session.getAttribute("id");//세션 id가져오기
		mem=orderservice.member(id);//고객 정보 가져오기
		model.addAttribute("member", mem);
		logger.info("mem"+mem);
		logger.info("id"+id);
		logger.info("vo"+vo);
		return "order/order";
	}
	@RequestMapping(value = "/orderAction", method = { RequestMethod.GET, RequestMethod.POST })
	public String orderActionPost(OrderVO vo,HttpSession session) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 결제 페이지 진입");
		String id = (String) session.getAttribute("id");//세션 id가져오기
		vo.setId(id);
		orderservice.orderAction(vo);
		Integer num = vo.getOrdernum();
		
		return "redirect:/orderFinish?num="+num;
	}

	@RequestMapping(value = "/pointUp", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String pointUpPost(@RequestParam("getpoint") String getpoint,HttpSession session,MemberVO vo) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 결제 페이지 진입");
		int point =Integer.parseInt(getpoint);
		String id = (String) session.getAttribute("id");
		vo.setPoint(point);
		vo.setId(id);
		orderservice.point(vo);
		return "point";
	}
	@RequestMapping(value = "/orderFinish", method = { RequestMethod.GET, RequestMethod.POST })
	public String orderFinishGet(OrderVO vo,HttpSession session,Integer num,Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 결제완료페이지 진입");
		/*orderservice.orderAction(vo);*/
		vo = orderservice.orderFinish(num);
		model.addAttribute("order", vo);
		
		
		return "order/orderFinish";
	}
	
}
