package org.ics.user.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.ics.user.basic.AbstractPagedQuery;


@Entity
@Table(name = "t_user")
public class User extends AbstractPagedQuery<User> implements Serializable {
	private static final long serialVersionUID = -6431399010450598889L;
	private Long id;
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String phone;
	private int status;
	private Date createDate;
	private Set<Role> roles = new HashSet<Role>();

	public User() {
		super();
	}

	public User(String username, String password, String nickname) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 20, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "username", length = 30)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 30)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "nickname", length = 30)
	//@NotNull(message = "昵称不能为空")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	// @Email(message="邮箱格式不正确")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "t_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + status;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (status != other.status)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", nickname=" + nickname + ", email=" + email
				+ ", phone=" + phone + ", status=" + status + ", createDate="
				+ createDate + ", roles=" + roles + "]";
	}

	@Override
	public Query buildQuery(Session session, boolean isQueryTotalCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getQueryParams(Map<String, Object> queryParams) {
		if (!StringUtils.isEmpty(username)) {
			queryParams.put("username", username);

		}
	}

}
