package org.ics.user.service;

import org.ics.user.basic.AbstractPagedQuery;
import org.ics.user.bean.User;

/**
 * @description TODO
 * @filename IUserService.java
 * @create on 2013-8-24 下午10:23:54
 * @author <a href="mailto:joe.zhjiang@gmail.com">joe</a>  
 * @version 1.0   
 */

public interface IUserService {
	public void add(User user);
	public void list();
	public void update(User user);
	public void delete(Long id);
	/**
	 * 获取分页数据
	 * 
	 * @param <T>
	 * @param entityClass
	 *            实体类
	 * @param pagedQuery
	 *            分页实体及分页信息
	 */
	void getScrollData(AbstractPagedQuery<User> pagedQuery);
}
