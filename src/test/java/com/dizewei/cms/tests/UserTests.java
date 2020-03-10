package com.dizewei.cms.tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dizewei.cms.dao.ArticleDao;
import com.dizewei.cms.dao.ChannelDao;
import com.dizewei.cms.dao.UserDao;
import com.dizewei.cms.pojo.Collect;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class UserTests {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ChannelDao channelDao;
	
	@Test
	public void test() {
//		List<User> userList = userDao.select(null);
//		System.out.println(userList);
//		channelDao.select(null);
//		
//		User user = new User();
//		user.setNickname("lisi");
////		userDao.insert(user);
//		user.setId(200);
////		userDao.update(user);
//		
////		userDao.delete("200");
//		
//		User selectById = userDao.selectById(199);
//		System.out.println(selectById);
		
		Collect collect = new Collect();
		collect.setText("雷军");
		List<Collect> list = userDao.selectCollect(collect);
		for (Collect s : list) {
			System.out.println(s);
		}
		
	}
}
