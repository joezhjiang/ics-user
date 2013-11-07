package org.ics.user.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.ics.user.bean.User;
import org.ics.user.service.IUserService;
import org.springframework.stereotype.Controller;

/**
 * @description TODO
 * @filename UserManagerAction.java
 * @create on 2013-8-26 下午11:22:33
 * @author <a href="mailto:joe.zhjiang@gmail.com">joe</a>
 * @version 1.0
 */

@Controller
public class UserManagerAction {
	private final Logger logger = Logger.getLogger(this.getClass());
	@Resource
	private IUserService userService;

	public String list() {
		User pagedQuery = new User();
		pagedQuery.setCurrPage(1);
		pagedQuery.setPageSize(8);
		userService.getScrollData(pagedQuery);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("pagedQuery", pagedQuery);
		logger.info("queryResults size is "+pagedQuery.getQueryResults().size());
		return "user.list";
	}

	public String add() {
		User user = new User("joseph", "123456", "joe");
		userService.add(user);
		return "user.add";
	}

	public String update() {
		userService.update(null);
		return "user.update";
	}

	public String delete() {
		userService.delete();
		return "user.delete";
	}

}
