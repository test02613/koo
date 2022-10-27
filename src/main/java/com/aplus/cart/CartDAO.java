package com.aplus.cart;

import java.util.List;

import com.aplus.item.ItemAttrVO;

public interface CartDAO {
	
	public List<CartVO> cart(String id) throws Exception;

	public ItemAttrVO cartcode(ItemAttrVO attr) throws Exception;

	public void cartinsert(CartVO vo) throws Exception;

}
