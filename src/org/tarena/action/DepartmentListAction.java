package org.tarena.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.tarena.entity.Department;
import org.tarena.service.DepartmentService;

@Controller
public class DepartmentListAction {
	
	private List<Department> depts;
	
	@Resource
	private DepartmentService deptService;
	
	public String execute(){
		depts = deptService.loadDepartments();
		return "success";
	}

	public List<Department> getDepts() {
		return depts;
	}

	public void setDepts(List<Department> depts) {
		this.depts = depts;
	}

	public DepartmentService getDeptService() {
		return deptService;
	}

	public void setDeptService(DepartmentService deptService) {
		this.deptService = deptService;
	}
	
	
	
}
