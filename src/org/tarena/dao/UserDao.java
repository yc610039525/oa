package org.tarena.dao;

import java.util.List;

import org.tarena.entity.User;

public interface UserDao {
	public List<User> findAll();
	public List<User> findUsers(final Integer deptId, final String name,
			final int beginIndex,final int pageSize);
}
