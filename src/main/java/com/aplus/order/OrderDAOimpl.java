package com.aplus.order;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplus.item.ItemAttrVO;
import com.aplus.model.MemberVO;



@Repository
public class OrderDAOimpl implements OrderDAO{

	@Autowired SqlSession sql;

	@Override
	public ItemAttrVO order_item(Integer code) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Order_SQL.order_item",code);
	}

	@Override
	public MemberVO member(String id) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Order_SQL.order_member",id);
	}

	@Override
	public void orderAction(OrderVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert("mapper.Order_SQL.orderAction",vo);
		
	}

	@Override
	public OrderVO orderFinish(Integer num) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Order_SQL.order_finish",num);
	}

	@Override
	public MemberVO point(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Order_SQL.point_update",vo);
	}
}
