package org.tarena.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.tarena.dao.DepartmentDao;
import org.tarena.entity.Department;

@Repository
public class HibernateDepartmentDao implements DepartmentDao{
	@Resource
	private HibernateTemplate template;
	
	public List<Department> findAll() {
		List<Department> list = 
			template.find("from Department");
		return list;
	}

}
