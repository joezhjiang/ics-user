package org.ics.user.service;

import org.ics.basic.service.BasicServiceTest;
import org.ics.user.bean.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @description TODO
 * @filename UserServiceTest.java
 * @create on 2013-8-25 上午12:48:43
 * @author <a href="mailto:joe.zhjiang@gmail.com">joe</a>
 * @version 1.0
 */

public class UserServiceTest extends BasicServiceTest {
	private IUserService userService;

	@Before
	public void init() {
		userService = (IUserService) applicationContext.getBean("userService");
	}

	@Test
	public void testAdd() {
		User user = new User("joseph", "123456", "joe");
		userService.add(user);
		Assert.assertNull(user.getId());

	}

	@Test
	public void testList() {
		// fail("Not yet implemented");
	}

}
