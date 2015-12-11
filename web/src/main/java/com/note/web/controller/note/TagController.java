package com.note.web.controller.note;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.note.common.HTTPCodeStatus;
import com.note.model.note.Tag;
import com.note.service.note.TagServices;
import com.note.web.controller.BaseController;
import com.note.web.entity.ResponseEntity;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping(value = "/tag")
public class TagController extends BaseController {

	@Resource(name = "tagService")
	private TagServices tagService;
	

	@ResponseBody
    @RequestMapping(value="list")
	public ResponseEntity list(){
		List<Tag> tags = tagService.list();
		page.setResult(tags);
		return returnSuccess(HTTPCodeStatus.HTTPCODE_OK, page, HTTPCodeStatus.HTTPCODE_OK_MESSAGE);
	}
}
 