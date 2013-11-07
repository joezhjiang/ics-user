package org.ics.user.dao.impl;

import java.util.List;

import org.ics.basic.dao.impl.BasicDaoImpl;
import org.ics.user.bean.User;
import org.ics.user.dao.IUserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends BasicDaoImpl<User> implements IUserDao {

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
