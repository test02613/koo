package com.aplus.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplus.item.ItemAttrVO;

@Repository
public class CartDAOimpl implements CartDAO{

	@Autowired SqlSession sql;

	@Override
	public List<CartVO> cart(String id) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.Cart_SQL.cart",id);
	}

	@Override
	public ItemAttrVO cartcode(ItemAttrVO attr) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Cart_SQL.cart_code",attr);
	}

	@Override
	public void cartinsert(CartVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert("mapper.Cart_SQL.cart_insert",vo);
	}

}
