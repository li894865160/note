package com.note.web.controller.note;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.note.model.note.Category;
import com.note.service.note.CategoryServices;
import com.note.web.controller.BaseController;
import com.note.web.entity.ResponseEntity;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {

	@Resource(name = "categoryService")
	private CategoryServices categoryService;
	

	
	@ResponseBody
    @RequestMapping(value="list")
	public ResponseEntity list(){
		List<Category> tags = categoryService.list();
		return responseEntity(200, "成功", tags.size(), tags);
	}
}
 