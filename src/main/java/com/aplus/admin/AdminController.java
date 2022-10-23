package com.aplus.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aplus.controller.MemberController;
import com.aplus.item.ItemAttrVO;
import com.aplus.item.ItemService;
import com.aplus.item.ItemVO;
import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;
import com.aplus.review.ReviewVO;
import com.aplus.service.MemberService;
@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private AdminService adminservice;
	@Autowired
	private ItemService itemservice;
	@RequestMapping(value = "/admin_main", method = RequestMethod.GET)
	public String admin_mainGET(MemberVO vo,HttpServletResponse response, HttpSession session) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 관리자 페이지 진입");
		response.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		int admin =  (int) session.getAttribute("admin");
		
		
		if(admin == 0) {
			out.print("<script>alert('\" 보노보노 \"'); history.go(-1);</script>" );
			logger.info("vo1"+admin);
			out.close();
			return "main/main";
		}else if(admin == 1) {
			logger.info("vo2"+vo);
			return "admin/admin_main";
		}else {
			
			return"member/login";
		}
	}
	
	@RequestMapping(value = "/iteminsert", method = RequestMethod.GET)
	public String iteminsertGET(Model model,HttpSession session,ItemVO vo ,Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 아이템작성 페이지 진입");
		vo.setItemnum(num);
		vo=adminservice.itemattr(vo);
		model.addAttribute("item", vo);
		return "admin/iteminsert";
	}
	
	@RequestMapping(value = "/iteminsertAction", method = RequestMethod.POST)
	public String iteminsertActionGET(Model model,HttpSession session,ItemVO vo) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 아이템작성 진행");
		adminservice.iteminsertAction(vo);
		return "redirect:/admin_main";
	}

	@RequestMapping(value = "/itemupdateAction", method = RequestMethod.POST)
	public String itemupdateActionGET(Model model,HttpSession session,ItemVO vo ,Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 아이템작성 진행");
		vo.setItemnum(num);
		adminservice.itemupdateAction(vo);
		return "redirect:/admin_main";
	}
	
	
	@RequestMapping(value = "/itemselect", method = RequestMethod.GET)
	public String itemselectGET(Model model,HttpSession session,ItemVO vo,Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 아이템선택 페이지 진입");
		model.addAttribute("num", num);
		List<ItemVO> list = adminservice.itemselect(vo);
		model.addAttribute("list", list);
		logger.info("vo"+vo);
		return "admin/itemselect";
	}
	
	@RequestMapping(value = "/attrlist", method = RequestMethod.GET)
	public String attrlistGET(Model model,HttpSession session,ItemAttrVO vo,Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 아이템작성 페이지 진입");
		 List<ItemAttrVO> list = itemservice.itemAttr(num);
		model.addAttribute("list", list);
		
		return "admin/attrlist";
	}
	
	@RequestMapping(value = "/attrinsert", method = RequestMethod.GET)
	public String attrinsertGET(Model model,HttpSession session,ItemVO vo,Integer num,Integer code,ItemAttrVO attr) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 아이템작성 페이지 진입");
		if(code == null) {
			vo.setItemnum(num);
			vo=adminservice.itemattr(vo);
			model.addAttribute("item", vo);
			model.addAttribute("num", 1);
		}else {
			attr.setItemcode(code);
			attr = adminservice.attrupdate(attr);
			model.addAttribute("item", attr);
			model.addAttribute("num", 2);
		}
		
		
		return "admin/attrinsert";
	}
	
	@RequestMapping(value = "/itemattrAction", method = RequestMethod.POST)
	public String attrinsertActionGET(Model model,HttpSession session,ItemAttrVO vo) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 아이템작성 진행");
		adminservice.itemattrAction(vo);
		return "redirect:/admin_main";
	}
	
	@RequestMapping(value = "/attrupdateAction", method = {RequestMethod.POST,RequestMethod.GET})
	public String attrupdateGET(Model model,HttpSession session,ItemAttrVO vo,Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 속성 진행 페이지 진입");
		adminservice.attrupdateAction(vo);
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> wlsgod 페이지 진입");
		
		return "redirect:/admin_main";
	}
	
	@RequestMapping(value = "/memberadmin", method = RequestMethod.GET)
	public String adminmemberGET(Model model,HttpSession session,MemberVO vo ,Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 아이템작성 페이지 진입");
		List<MemberVO> list=adminservice.adminmember();
		
		model.addAttribute("list", list);
		return "admin/adminmember";
	}
	@RequestMapping(value = "/black", method = {RequestMethod.POST,RequestMethod.GET})
	public String blackGET(Model model,HttpSession session,MemberVO vo,String id) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 상태 페이지 진입");
		vo.setId(id);
		adminservice.black(vo);
		return "redirect:/memberadmin";
	}
	
	@RequestMapping(value = "/alive", method = {RequestMethod.POST,RequestMethod.GET})
	public String aliveGET(Model model,HttpSession session,MemberVO vo,String id) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 상태 페이지 진입");
		vo.setId(id);
		adminservice.alive(vo);
		return "redirect:/memberadmin";
	}
	
	@RequestMapping(value = "/admin_order", method = {RequestMethod.POST,RequestMethod.GET})
	public String admin_orderGET(Model model,HttpSession session,OrderVO vo) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 상태 페이지 진입");
		List<OrderVO> list =adminservice.admin_order();
		
		model.addAttribute("list", list);
		return "admin/admin_order";
	}
	
	@RequestMapping(value = "/state_selcted", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public void state_selctedGET(OrderVO vo, Model model,@RequestParam("state") String state ,@RequestParam("num") Integer num) throws Exception {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  진입");
		vo.setOrdernum(num);
		vo.setState(state);
		adminservice.state_selcted(vo);
	}
}