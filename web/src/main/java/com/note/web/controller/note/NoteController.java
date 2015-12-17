package com.note.web.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.note.common.HTTPCodeStatus;
import com.note.common.Page;
import com.note.model.note.Note;
import com.note.model.user.User;
import com.note.service.note.NoteServices;
import com.note.web.controller.BaseController;
import com.note.web.entity.ResponseEntity;
import com.note.web.security.annotation.Authority;
import com.note.web.security.common.AuthorityType;
import com.note.web.security.util.SecurityUtil;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping(value = "/note")
public class NoteController extends BaseController {

    @Resource(name = "noteService")
    private NoteServices noteService;
    
    /**
     * 添加
     * @param note
     * @return
     * @author baixiaozheng
     * @Date 2015年12月17日 下午11:56:12
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    @Authority(type = AuthorityType.SECURITY)
    private ResponseEntity add(Note note){
        User user = SecurityUtil.currentLogin();
        note.setUserId(user.getId());
        note = noteService.add(note);
        return returnSuccess(HTTPCodeStatus.HTTPCODE_OK);
    }
    
    /**
     * 列表
     * @param page
     * @param note
     * @return
     * @author baixiaozheng
     * @Date 2015年12月17日 下午11:56:20
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    @Authority(type = AuthorityType.SECURITY)
    public ResponseEntity list(Page page, Note note){
    	note.setUserId(SecurityUtil.currentLogin().getId());
    	page = noteService.list(page, note);
    	return returnSuccess(HTTPCodeStatus.HTTPCODE_OK, page);
    }
    
    /**
     * 根据id获取
     * @param id
     * @return
     * @author baixiaozheng
     * @Date 2015年12月17日 下午11:56:29
     */
    @ResponseBody
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @Authority(type = AuthorityType.ANYMOUS)
    public ResponseEntity getById(@PathVariable("id") Integer id){
    	Note note = noteService.getById(id);
    	return returnSuccess(HTTPCodeStatus.HTTPCODE_OK, note);
    }
    
    /**
     * 更新
     * @param id
     * @param note
     * @return
     * @author baixiaozheng
     * @Date 2015年12月17日 下午11:56:37
     */
    @ResponseBody
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    @Authority(type = AuthorityType.SECURITY)
    public ResponseEntity update(@PathVariable("id") Integer id, Note note){
    	Integer userId = SecurityUtil.currentLogin().getId();
    	Note old = noteService.getById(id);
    	if(!old.getUserId().equals(userId)){
    		return returnFailed(301, "只允许更新自己的");
    	}
    	noteService.update(note);
    	return returnSuccess(HTTPCodeStatus.HTTPCODE_OK, note);
    }
}
