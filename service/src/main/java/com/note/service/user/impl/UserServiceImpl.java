package com.note.service.user.impl; 

import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.note.dao.user.UserDao;
import com.note.model.user.User;
import com.note.model.user.UserRole;
import com.note.service.user.UserServices;
import com.note.util.md5.MD5Util;
import com.note.util.validate.ValidateUtil;

@Service(value = "userService")
public class UserServiceImpl implements UserServices{

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<User> getAll() {
		return userDao.getAll();
	}

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.RuntimeException.class)
    public User add(User user) {
        Date now = new Date();
        user.setEnable(true);
        user.setRegTime(now);
        user.setPassword(MD5Util.digest(user.getPassword()));
        user.setRoles(EnumSet.of(UserRole.NORMAL_USER));
        return userDao.add(user);
    }
	
    @Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User getUserByEmail(String email) {
		if (ValidateUtil.isEmpty(email))
			return null;
		return userDao.getUserByEmail(email);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User getUserByMobile(String mobile) {
		if (ValidateUtil.isEmpty(mobile)) {
			return null;
		}
		return userDao.getUserByMobile(mobile);
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User getById(int id){
		return userDao.getById(id);
	}
	
	@Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.RuntimeException.class)
    public User update(User user) {
        return userDao.update(user);
    }

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.RuntimeException.class)
	public void updateUserIpAndLastestLoginTime(User user, String ip) {
		user.setLastestLoginIp(ip);
		user.setLastestLoginTime(new Date());
		userDao.update(user);
	}

}
 