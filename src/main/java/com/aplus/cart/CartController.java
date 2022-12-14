package com.aplus.cart;

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
import com.aplus.item.ItemAttrVO;


@Controller
public class CartController {
	@Autowired
	private CartService cartservice;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cartGet(Model model,HttpSession session,CartVO vo) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>장바구니 진입");
		
		String id = (String) session.getAttribute("id");
		List<CartVO> list = cartservice.cart(id);
		model.addAttribute("list", list);
		logger.info("list"+list);
		
		
		return "cart/cart";
	}
	@RequestMapping(value = "/cartorder", method = RequestMethod.GET)
	public String cartorderGet(Model model,HttpSession session,CartVO vo) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>장바구니 진입");
		
		String id = (String) session.getAttribute("id");
		List<CartVO> list = cartservice.cart(id);
		model.addAttribute("list", list);
		logger.info("list"+list);
		
		
		return "cart/cart";
	}
	
	@RequestMapping(value = "/cartinsert", method = {RequestMethod.GET,RequestMethod.POST})
	public String cartinsertGet(Model model,HttpSession session,CartVO vo,Integer code,ItemAttrVO attr) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>장바구sl insert 진입");
		String id = (String) session.getAttribute("id");
		vo.setId(id);
		attr.setItemcode(code);
		attr =cartservice.cartcode(attr);
		String color =attr.getItemcolor();
		Integer cost =attr.getItemcost();
		String name =attr.getItemname();
		vo.setItemcode(code);
		vo.setItemcost(cost);
		vo.setItemname(name);
		vo.setItemattr(color);
		
		cartservice.cartinsert(vo);
		
		
		return "redirect:/cart";
	}

}
