package com.note.service.note;

import java.util.List;

import com.note.common.Page;
import com.note.model.note.Note;

/**
 * note service
 * 
 * @author baixiaozheng
 * @Date 2015年12月17日 下午11:29:45
 */
public interface NoteServices {

	/**
	 * 添加
	 * 
	 * @param note
	 * @return
	 * @author baixiaozheng
	 * @Date 2015年12月17日 下午11:31:48
	 */
    Note add(Note note);
    
    /**
     * 更新
     * 
     * @param note
     * @return
     * @author baixiaozheng
     * @Date 2015年12月17日 下午11:31:57
     */
    Note update(Note note);
    
    /**
     * 获取所有
     * 
     * @return
     * @author baixiaozheng
     * @Date 2015年12月17日 下午11:32:04
     */
    List<Note> getAll();
    
    /**
     * 根据id查询
     * @param id
     * @return
     * @author baixiaozheng
     * @Date 2015年12月17日 下午11:32:13
     */
    Note getById(int id);
    
    /**
     * 返回分页对象
     * @param page
     * @param note
     * @return
     * @author baixiaozheng
     * @Date 2015年12月17日 下午11:32:21
     */
    Page list(Page page, Note note);
}
