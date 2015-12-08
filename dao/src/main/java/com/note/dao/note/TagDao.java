package com.note.dao.note;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.note.dao.BaseDao;
import com.note.model.note.Tag;

@Repository(value="tagDao")
public class TagDao extends BaseDao {

	@Override
	protected Class<?> entityClass() {
		return Tag.class;
	}

	public List<Tag> getAll(){
		return super.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tag> list(){
		String sql = "select * from tag where enable=true";
		return (List<Tag>) super.listEntityWithSql(sql);
	}
}
 