package com.note.model.user;

/**
 * 用户角色
 *
 */
public enum UserRole {
	
	NORMAL_USER {
        @Override
        public String toString() {
            return "普通用户";
        }
    },
	ADMIN_ROLE {
        @Override
        public String toString() {
            return "管理员";
        }
    }
}
