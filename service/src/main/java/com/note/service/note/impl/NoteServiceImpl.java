package com.note.service.note.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.note.common.Page;
import com.note.dao.note.NoteDao;
import com.note.model.note.Note;
import com.note.service.note.NoteServices;

@Service(value = "noteService")
public class NoteServiceImpl implements NoteServices {

    @Resource(name = "noteDao")
    private NoteDao noteDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.RuntimeException.class)
    public Note add(Note note) {
        note.setTitlePic(_getTitleImage(note.getContent()));
        Date now = new Date();
        note.setTitlePic(_getTitleImage(note.getContent()));
        note.setCreateTime(now);
        note.setUpdateTime(now);
        return noteDao.add(note);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.RuntimeException.class)
    public Note update(Note note) {
        Date now = new Date();
        note.setTitlePic(_getTitleImage(note.getContent()));
        note.setUpdateTime(now);
        return noteDao.update(note);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Note> getAll() {
        return noteDao.getAll();
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Note getById(int id) {
        return noteDao.getById(id);
    }

    /**
     * 取第一张图片作为标题图片
     * 
     * @param content
     * @return
     * @author baixiaozheng
     * @Date 2015年12月7日 上午11:52:20
     */
    private String _getTitleImage(String content) {
        if (content == null) {
            content = "";
        }
        String str = null;
        if (content.indexOf("<img") != -1) {
            str = content.substring(content.indexOf("<img") + "<img".length(), content.length() - 1);
            str = str.substring(str.indexOf("src=\"") + "src=\"".length(), str.length() - 1);
            str = str.substring(0, str.indexOf("\""));
        } else {
            str = "images/zanwutupian.gif";
        }
        return str;
    }

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Page list(Page page, Note note) {
		List<Note> list = noteDao.list(page, note);
		page.setResult(list);
		page.setTotalCount(getAll().size());
		return page;
	}
}
