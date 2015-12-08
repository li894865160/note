package com.note.dao.note;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.note.dao.BaseDao;
import com.note.model.note.Category;

@Repository(value="categoryDao")
public class CategoryDao extends BaseDao {

	@Override
	protected Class<?> entityClass() {
		return Category.class;
	}

	public List<Category> getAll(){
		return super.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> list(){
		String sql = "select * from category where enable=true";
		return (List<Category>) super.listEntityWithSql(sql);
	}
}
 