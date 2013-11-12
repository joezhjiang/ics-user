package org.ics.user.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.ics.user.bean.User;
import org.ics.user.service.IUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @description TODO
 * @filename UserManagerAction.java
 * @create on 2013-8-26 下午11:22:33
 * @author <a href="mailto:joe.zhjiang@gmail.com">joe</a>
 * @version 1.0
 */

@Controller
@Scope("prototype")
public class UserManagerAction extends ActionSupport {
	private static final long serialVersionUID = 1052277172722877256L;
	private final Logger logger = Logger.getLogger(this.getClass());
	@Resource
	private IUserService userService;
	private User user;

	public String list() {
		logger.info(user);
		if (null == user) {
			user = new User();
			user.setCurrPage(1);
			user.setPageSize(8);
		}

		userService.getScrollData(user);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("pagedQuery", user);
		return "user.list";
	}

	public String detail() {
		return "user.detail";
	}

	public String add() throws Exception {
		try {
			userService.add(user);
			this.addActionMessage("新增用户成功");
			return "user.add.sucess";
		} catch (Exception e) {
			throw e;
		}
	}

	public String update() {
		userService.update(null);
		return "user.update";
	}

	public String delete() throws Exception {
		try {
			userService.delete(user.getId());
			this.addActionMessage("删除用户成功");
			return "user.delete.sucess";
		} catch (Exception e) {
			throw e;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
