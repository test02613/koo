package com.aplus.item;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAOimpl  implements ItemDAO {

	@Autowired SqlSession sql;
	
	@Override
	public List<ItemVO> itemList(Integer cat) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("mapper.Item_SQL.item_list",cat);
	}


}
