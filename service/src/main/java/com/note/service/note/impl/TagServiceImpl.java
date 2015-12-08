package com.note.service.note.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.note.dao.note.TagDao;
import com.note.model.note.Tag;
import com.note.service.note.TagServices;

@Service(value = "tagService")
public class TagServiceImpl implements TagServices {

	@Resource(name = "tagDao")
	private TagDao tagDao;
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Tag> list() {
		return tagDao.list();
	}

}
 