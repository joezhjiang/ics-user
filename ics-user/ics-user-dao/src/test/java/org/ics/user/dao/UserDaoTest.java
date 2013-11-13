package org.ics.user.dao;

import java.util.Calendar;

import org.ics.basic.dao.BasicDaoTest;
import org.ics.user.bean.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @description TODO
 * @filename UserDaoTest.java
 * @create on 2013-8-22 下午10:41:50
 * @author <a href="mailto:joe.zhjiang@gmail.com">joe</a>
 * @version 1.0
 */

public class UserDaoTest extends BasicDaoTest {
	private IUserDao userDao;

	@Before
	public void init() {
		userDao = (IUserDao) applicationContext.getBean("userDao");
	}

	@Test
	public void testSaveEntity() {
		try {
			for (int i = 0; i < 100; i++) {
				User user = new User("joseph", "123456", "joe");
				userDao.saveEntity(user);
				Assert.assertNull(user.getId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateEntity() {
		User user = (User) userDao.findEntity(User.class, 1L);
		user.setCreateDate(Calendar.getInstance().getTime());
		User user1 = (User) userDao.updateEntity(user);
		Assert.assertEquals(user, user1);
	}

	@Test
	public void testDeleteEntity() {

	}

	@Test
	public void testFindEntity() {
		User user = (User) userDao.findEntity(User.class, 1L);
		Assert.assertNotNull(user);
	}

	@After
	public void destory() {
		userDao = null;
	}

}
