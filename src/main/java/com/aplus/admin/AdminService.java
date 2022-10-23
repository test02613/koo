package com.aplus.admin;

import java.util.List;

import com.aplus.item.ItemAttrVO;
import com.aplus.item.ItemVO;
import com.aplus.model.MemberVO;

public interface AdminService {

	
	public void iteminsertAction(ItemVO vo) throws Exception;
	
	public List<ItemVO> itemselect(ItemVO vo) throws Exception;
	
	public ItemVO itemattr(ItemVO vo) throws Exception;
	
	public void itemattrAction(ItemAttrVO vo) throws Exception;
	
	public ItemVO itemupdateAction(ItemVO vo) throws Exception;
	
	public ItemAttrVO attrupdate(ItemAttrVO vo) throws Exception;
	
	public ItemAttrVO attrupdateAction(ItemAttrVO vo) throws Exception;
	
	public List<MemberVO> adminmember() throws Exception;
	
	public MemberVO black(MemberVO vo) throws Exception;
}
