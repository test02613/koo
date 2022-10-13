package com.aplus.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplus.item.ItemAttrVO;


@Service
public class CartServiceimpl implements CartService{
	@Autowired CartDAO dao;

	@Override
	public List<CartVO> cart(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.cart(id);
	}

}
