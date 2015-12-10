package com.note.service.user; 

import java.util.List;

import com.note.model.user.User;


public interface UserServices {

	List<User> getAll();
	
	User add(User user);
	
	User getUserByEmail(String email);

	User getUserByMobile(String mobile);

	User getById(int id);
	
	User update(User user);
	
	void updateUserIpAndLastestLoginTime(User user, String ip);
}
 