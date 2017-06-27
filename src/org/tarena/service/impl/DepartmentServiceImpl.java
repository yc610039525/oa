package org.tarena.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.dao.DepartmentDao;
import org.tarena.entity.Department;
import org.tarena.service.DepartmentService;

@Service

public class DepartmentServiceImpl implements DepartmentService{
	@Resource
	private DepartmentDao deptDao;
	
	@Transactional(readOnly=true)
	public List<Department> loadDepartments() {
		List<Department> list = deptDao.findAll();
		return list;
	}

}
