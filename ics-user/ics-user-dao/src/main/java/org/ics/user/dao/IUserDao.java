package org.ics.user.dao;

import java.util.List;

import org.ics.basic.dao.IBasicDao;
import org.ics.user.bean.User;

public interface IUserDao extends IBasicDao<User> {
	List<User> findAllUsers();
}
