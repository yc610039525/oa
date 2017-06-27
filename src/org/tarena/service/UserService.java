package org.tarena.service;

import java.util.List;

import org.tarena.entity.User;

public interface UserService {
	public List<User> loadUsers(Integer deptId,String name,int page,int pageSize);
}
