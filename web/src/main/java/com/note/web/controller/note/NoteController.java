package com.note.web.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.note.model.note.Note;
import com.note.model.user.User;
import com.note.service.note.NoteServices;
import com.note.web.controller.BaseController;
import com.note.web.entity.ResponseEntity;
import com.note.web.security.annotation.Authority;
import com.note.web.security.common.AuthorityType;
import com.note.web.security.util.SecurityUtil;

@Controller
@RequestMapping(value = "/note")
public class NoteController extends BaseController {

    @Resource(name = "noteService")
    private NoteServices noteService;
    
    @SuppressWarnings("rawtypes")
    @ResponseBody
    @RequestMapping(value="add")
    @Authority(type = AuthorityType.SECURITY)
    private ResponseEntity add(Note note){
        User user = SecurityUtil.currentLogin();
        note.setUserId(user.getId());
        note = noteService.add(note);
        return responseEntity(200, note, "成功");
    }
    
    @SuppressWarnings("rawtypes")
    @ResponseBody
    @RequestMapping(value="test")
    @Authority(type = AuthorityType.SECURITY)
    private ResponseEntity test(){
        //SecurityUtil.setSecurityUser(null);
        return responseEntity(200, null, "成功");
    }
}
