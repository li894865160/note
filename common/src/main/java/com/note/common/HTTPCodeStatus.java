package com.note.common;

/**
 * HTTP返回状态码
 * @author baixiaozheng
 *
 */
public class HTTPCodeStatus {

	/**
	 * 成功
	 */
	public static final int HTTPCODE_OK = 200;
	public static final String HTTPCODE_OK_MESSAGE = "成功";
	
	/**
	 * 用户未登陆
	 */
	public static final int HTTPCODE_USER_NOTLOGIN = 201;
	public static final String HTTPCODE_USER_NOTLOGIN_MESSAGE = "用户未登陆";
	
	/**
	 * 登陆失败
	 */
	public static final int HTTPCODE_LOGIN_ERROR = 202;
	public static final String HTTPCODE_LOGIN_ERROR_MESSAGE = "登陆失败";
}
