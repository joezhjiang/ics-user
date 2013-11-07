package org.ics.user.service.impl;

import javax.annotation.Resource;

import org.ics.user.basic.AbstractPagedQuery;
import org.ics.user.bean.User;
import org.ics.user.dao.IUserDao;
import org.ics.user.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @description TODO
 * @filename UserServiceImpl.java
 * @create on 2013-8-24 下午10:26:00
 * @author <a href="mailto:joe.zhjiang@gmail.com">joe</a>  
 * @version 1.0   
 */

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public void add(User user) {
		userDao.saveEntity(user);
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getScrollData(AbstractPagedQuery<User> pagedQuery) {
		// TODO Auto-generated method stub
		userDao.getScrollData(User.class, pagedQuery);
	}
	
	
}
