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
}
