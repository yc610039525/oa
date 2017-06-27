package org.tarena.dao;

import java.util.List;

import org.tarena.entity.Department;

public interface DepartmentDao {
	public List<Department> findAll();
}
