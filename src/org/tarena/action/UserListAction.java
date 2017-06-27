package org.tarena.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tarena.entity.User;
import org.tarena.service.UserService;

@Controller
@Scope("prototype")
public class UserListAction {
	//�������������
	private Integer deptId;//����ID
	private String name;//Ա����
	private int page = 1;
	//Ҫ�����Ľ��
	private List<User> users;//��ѯ���
	
	@Resource
	private UserService userService;
	
	public String execute(){
		System.out.println(deptId);
		System.out.println(name);
		users = userService.loadUsers(
				deptId,name,page,5);
		return "success";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
