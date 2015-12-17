package com.note.web.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
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
    
    @ResponseBody
    @RequestMapping(value="add")
    @Authority(type = AuthorityType.SECURITY)
    private ResponseEntity add(Note note){
        User user = SecurityUtil.currentLogin();
        note.setUserId(user.getId());
        note = noteService.add(note);
        return returnSuccess(HTTPCodeStatus.HTTPCODE_OK);
    }
    
    @ResponseBody
    @RequestMapping(value="test", method = RequestMethod.GET)
    @Authority(type = AuthorityType.SECURITY)
    private ResponseEntity testPut(){
        //SecurityUtil.setSecurityUser(null);
        return returnSuccess(HTTPCodeStatus.HTTPCODE_OK, null, HTTPCodeStatus.HTTPCODE_OK_MESSAGE);
    }
    
    @ResponseBody
    @RequestMapping(value="list")
    @Authority(type = AuthorityType.SECURITY)
    public ResponseEntity list(Page page, Note note){
    	note.setUserId(SecurityUtil.currentLogin().getId());
    	page = noteService.list(page, note);
    	return returnSuccess(HTTPCodeStatus.HTTPCODE_OK, page);
    }
}
