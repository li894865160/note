package com.note.dao.note;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.note.dao.BaseDao;
import com.note.model.note.Category;

@SuppressWarnings("unchecked")
@Repository(value="categoryDao")
public class CategoryDao extends BaseDao {

	@Override
	protected Class<?> entityClass() {
		return Category.class;
	}

	public List<Category> getAll(){
		return super.list();
	}
	
	public List<Category> list(){
		String sql = "select * from category where enable=true";
		return (List<Category>) super.listEntityWithSql(sql);
	}
	
	public Category add(Category category){
		return super.add(category);
	}
	
	public Category getById(int id){
		return super.get(id);
	}
	
	public Category update(Category category){
		return super.update(category);
	}
	
	public List<Category> listByUserId(int userId){
		String sql = "select * from category where enable=:enable ";
		Map<String, Object> map = configMap(new String[]{"enable"}, new Object[]{true});
		if(userId > 0){
			sql += "and user_id=:userId";
			map.put("userId", userId);
		}
		return (List<Category>) super.listEntityWithSql(sql, map);
	}
}
 