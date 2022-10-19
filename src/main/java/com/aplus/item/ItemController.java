package com.aplus.item;

import java.security.Provider.Service;
import java.util.ArrayList;
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

import com.aplus.review.ReviewService;
import com.aplus.review.ReviewVO;




@Controller
public class ItemController {
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	@Autowired
	private ItemService itemservice;
	@Autowired
	private ReviewService reviewservice;
	
	
	
	
	@RequestMapping(value = "/itemListL", method = RequestMethod.GET)
	public String itemListLGET(ItemVO vo,Model model,HttpServletResponse response,Integer cat ) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 아이템 페이지 진입");
		List<ItemVO> list=itemservice.itemListL(cat);
		model.addAttribute("itemlist",list);
		
		logger.info("itemservice.itemList()"+list);
		return "item/itemList";
	}
	
	@RequestMapping(value = "/itemList", method = RequestMethod.GET)
	public String itemlistGET(ItemVO vo,Model model,HttpServletResponse response,Integer cat ) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 아이템 페이지 진입");
		List<ItemVO> list=itemservice.itemList(cat);
		model.addAttribute("itemlist",list);
		
		logger.info("itemservice.itemList()"+list);
		return "item/itemList";
	}
	
	@RequestMapping(value = "/itemDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String itemDetailGET(Integer num, Model model) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 아이템 디테일 진입");
		ItemVO vo = itemservice.itemDetail(num);
		 model.addAttribute("detail", vo);
		 List<ItemAttrVO> list = itemservice.itemAttr(num);
		 model.addAttribute("list1", list);
		 List<ReviewVO> review = reviewservice.reviewlist(num);
		 model.addAttribute("review", review);
		 logger.info("list"+list);
		 logger.info("vo"+vo);
		return "item/itemDetail";
	}
	
	@RequestMapping(value = "/colorChk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String colorChkGET(ItemAttrVO vo, Model model,@RequestParam("color") String color , @RequestParam("num") Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  진입");
		vo.setItemcolor(color);
		vo.setItemnum(num);
		
		/*List<ItemAttrVO> list = itemservice.colorChk(vo);*/
		vo = itemservice.colorChk(vo);
		Integer cost = vo.getItemcost();
		Integer code = vo.getItemcode();
		String to = Integer.toString(cost);
		String tt = Integer.toString(code);
		logger.info("uuuu"+cost);
		logger.info("vo"+vo);
		
		return to;
	}
	
	@RequestMapping(value = "/itemCode", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String itemCodeGET(ItemAttrVO vo, Model model,@RequestParam("color") String color , @RequestParam("num") Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  진입");
		vo.setItemcolor(color);
		vo.setItemnum(num);
		
		/*List<ItemAttrVO> list = itemservice.colorChk(vo);*/
		vo = itemservice.colorChk(vo);
		Integer cost = vo.getItemcode();
		String to = Integer.toString(cost);
		logger.info("uuuudddd"+cost);
		logger.info("vo"+vo);
		
		return to;
	}
	
	
	
	
	
}
