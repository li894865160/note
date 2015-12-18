package com.note.web.controller.user; 

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.note.common.HTTPCodeStatus;
import com.note.common.Page;
import com.note.model.user.User;
import com.note.service.user.UserServices;
import com.note.web.controller.BaseController;
import com.note.web.entity.ResponseEntity;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	@Autowired
	private UserServices userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity list(Page page){
		List<User> list = new ArrayList<User>();
		list = userService.getAll();
		page.setResult(list);
		return returnSuccess(HTTPCodeStatus.HTTPCODE_OK, page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity register(@ModelAttribute("user") User user){
	    user = userService.add(user);
	    return returnSuccess(HTTPCodeStatus.HTTPCODE_OK, user);
	}

}
 