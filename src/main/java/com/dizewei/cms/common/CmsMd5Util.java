package com.dizewei.cms.common;

import com.dizewi.common.utils.Md5Util;

public class CmsMd5Util {
	/**
	 * @Title: md5   
	 * @Description: cms密码加密   
	 * @param: @param str
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String md5(String str) {
		String string2md5 = Md5Util.stringMd5(str+"cmsPassword");
		return string2md5;
	}
	
	public static void main(String[] args) {
		System.out.println(md5("admin"));
	}
}
