package com.note.service.note;

import java.util.List;

import com.note.model.note.Category;

/**
 * 类别service
 * 
 * @author baixiaozheng
 * @Date 2015年12月17日 下午11:29:32
 */
public interface CategoryServices {

	/**
	 * 获取所有的标签
	 * 
	 * @return
	 * @author baixiaozheng
	 * @Date 2015年12月17日 下午11:29:12
	 */
	List<Category> list();
}
 