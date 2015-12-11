package com.note.dao.note;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.note.common.Page;
import com.note.dao.BaseDao;
import com.note.model.note.Note;


@Repository(value="noteDao")
public class NoteDao extends BaseDao{

    @Override
    protected Class<?> entityClass() {
        
        return Note.class;
    }

    /**
     * 添加
     * 
     * @param note
     * @return
     * @author baixiaozheng
     * @Date 2015年12月7日 上午11:35:16
     */
    public Note add(Note note){
        return super.add(note);
    }
    
    /**
     * 更新
     * 
     * @param note
     * @return
     * @author baixiaozheng
     * @Date 2015年12月7日 上午11:35:02
     */
    public Note update(Note note){
        return super.update(note);
    }
    
    /**
     * 获取所有
     * 
     * @return
     * @author baixiaozheng
     * @Date 2015年12月7日 上午11:39:01
     */
    public List<Note> getAll(){
        return super.list();
    }
    
    /**
     * 根据id查询
     * @param id
     * @return
     * @author baixiaozheng
     * @Date 2015年12月7日 上午11:39:10
     */
    public Note getById(int id){
        return super.get(id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Note> list(Page page, Note note){
    	final int firstResult = page.getCurrentPage() >= 1 ? page.getPageSize() * (page.getCurrentPage() - 1) : 0;
    	Map<String, Object> map = configMap(new String[]{"from", "pageSize"}, new Object[]{firstResult, page.getPageSize()});
    	String sql = "select * from note where 1=1 ";
    	sql += " limit :from, :pageSize";
    	return (List<Note>) super.listEntityWithSql(sql, map);
    }
}
