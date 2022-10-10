package com.aplus.item;

import java.security.Provider.Service;
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


import com.aplus.event.EventVO;

@Controller
public class ItemController {
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	@Autowired
	private ItemService itemservice;
	
	
	
	@RequestMapping(value = "/itemList", method = RequestMethod.GET)
	public String itemlistGET(ItemVO vo,Model model,HttpServletResponse response,Integer cat ) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 아이템 페이지 진입");
		List<ItemVO> list=itemservice.itemList(cat);
		model.addAttribute("itemlist",list);
		
		logger.info("itemservice.itemList()"+list);
		return "item/itemList";
	}
	
	
	
}
