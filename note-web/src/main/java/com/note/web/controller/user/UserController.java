package com.note.web.controller.user; 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.note.model.user.User;
import com.note.service.user.UserServices;
import com.note.util.request.RequestUtil;
import com.note.web.security.util.SecurityUtil;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserServices userService;
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public String list(Model model){
		List<User> list = new ArrayList<User>();
		list = userService.getAll();
		model.addAttribute("list", list);
		return "user/list";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user){
	    userService.add(user);
	    return "redirect:/logout"; 
	    //return list(model);
	}
	
	@RequestMapping(value="loginSuccess")
	public String loginSuccess(HttpServletRequest request) {
		User user = SecurityUtil.currentLogin();
		//System.out.println(user.getRealName()+"登录成功");
		user = userService.getById(user.getId());
		user.setLastestLoginTime(new Date());
		user.setLastestLoginIp(RequestUtil.getRemoteIPAddress(request));
		userService.update(user);
		return "redirect:list"; 
	}

	@RequestMapping(value="loginFailed")
	public String loginFailed() {
		System.out.println("登录失败");
		return "redirect:logout"; 
	}

}
 