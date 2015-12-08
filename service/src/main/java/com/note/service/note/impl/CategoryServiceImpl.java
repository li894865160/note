package com.note.service.note.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.note.dao.note.CategoryDao;
import com.note.model.note.Category;
import com.note.service.note.CategoryServices;

@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryServices {

	@Resource(name = "categoryDao")
	private CategoryDao categoryDao;
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Category> list() {
		return categoryDao.list();
	}

}
 