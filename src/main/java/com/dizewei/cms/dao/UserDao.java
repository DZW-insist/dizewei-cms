package com.dizewei.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.dizewei.cms.pojo.Collect;
import com.dizewei.cms.pojo.User;

public interface UserDao extends BaseDao<User>{
	/**
	 * @Title: selectByUsername   
	 * @Description: 根据用户名查找用户   
	 * @param: @param userName
	 * @param: @return      
	 * @return: User      
	 * @throws
	 */
	@Select("select * from cms_user where username=#{userName}")
	User selectByUsername(String userName);
	
	List<Collect> selectCollect(Collect collect);

}
