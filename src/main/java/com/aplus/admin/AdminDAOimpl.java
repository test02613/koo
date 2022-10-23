package com.aplus.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aplus.item.ItemAttrVO;
import com.aplus.item.ItemVO;
import com.aplus.model.MemberVO;
import com.aplus.order.OrderVO;
import com.aplus.review.ReviewVO;
@Repository
public class AdminDAOimpl implements AdminDAO{
	
	@Autowired SqlSession sql;

	@Override
	public void iteminsertAction(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		 sql.insert("mapper.Admin_SQL.item_Action", vo);
	}

	@Override
	public List<ItemVO> itemselect(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.Admin_SQL.item_select", vo);
	}

	@Override
	public ItemVO itemattr(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Admin_SQL.item_attr", vo);
	}

	@Override
	public void itemattrAction(ItemAttrVO vo) throws Exception {
		// TODO Auto-generated method stub
		 sql.insert("mapper.Admin_SQL.itemattr_Action", vo);
	}

	@Override
	public ItemVO itemupdateAction(ItemVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Admin_SQL.item_update", vo);
	}

	@Override
	public ItemAttrVO attrupdate(ItemAttrVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Admin_SQL.attr_update", vo);
	}

	@Override
	public ItemAttrVO attrupdateAction(ItemAttrVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Admin_SQL.attr_updateAction", vo);
	}

	@Override
	public List<MemberVO> adminmember() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.Admin_SQL.member_admin");
	}

	@Override
	public MemberVO black(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Admin_SQL.admin_black", vo);
	}

	@Override
	public MemberVO alive(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Admin_SQL.admin_alive", vo);
	}

	@Override
	public List<OrderVO> admin_order() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.Admin_SQL.admin_order");
	}

	@Override
	public OrderVO state_selcted(OrderVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Admin_SQL.state_selcted", vo);
	}

	@Override
	public List<ReviewVO> admin_review(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.Admin_SQL.admin_review");
	
	}

	@Override
	public ReviewVO reviewout(Integer num) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("mapper.Admin_SQL.reviewout", num);
	}
}
