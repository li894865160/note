package com.note.web.security.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.note.model.user.User;
import com.note.web.security.service.entity.SecurityUser;


/**
 * 当前登陆用户
 */
public class SecurityUtil {

    /**
     * 获取登陆用户
     */
    public static User currentLogin() {
        try {
            SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            return userDetails.getUser();
        } catch (Exception e) {
            return null;
        }
    }

    public static void setSecurityUser(User user) {
        try {
            SecurityUser userDetails = (SecurityUser) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            userDetails.setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
