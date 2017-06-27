package org.tarena.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.dao.UserDao;
import org.tarena.entity.User;
import org.tarena.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	@Transactional(readOnly=true)
	public List<User> loadUsers(
			Integer deptId,String name,int page,int pageSize) {
		int beginIndex = (page-1)*pageSize;
		List<User> list = 
			userDao.findUsers(deptId, name,beginIndex,pageSize);
		return list;
	}

}
