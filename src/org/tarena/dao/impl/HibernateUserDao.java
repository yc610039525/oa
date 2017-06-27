package org.tarena.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.tarena.dao.UserDao;
import org.tarena.entity.User;

@Repository
public class HibernateUserDao implements UserDao{
	@Resource
	private HibernateTemplate template;
	
	public List<User> findAll() {
		List<User> list = template.find("from User");
		return list;
	}

	public List<User> findUsers(
			final Integer deptId, final String name,
			final int beginIndex,final int pageSize) {
//		List<User> list = template.find(hql,params.toArray());
		//以回调函数方式使用session
		List<User> list = (List)template.execute(
		new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from User where 1=1";
				List<Object> params = new ArrayList<Object>();
				if(deptId != null && deptId != -1){
					hql += " and dept.departmentID=?";
					params.add(deptId);
				}
				if(name != null && !"".equals(name)){
					hql += " and username like ?";
					params.add("%"+name+"%");
				}
				Query query = session.createQuery(hql);
				//设置参数
				for(int i=0;i<params.size();i++){
					query.setParameter(i, params.get(i));
				}
				//设置分页参数
				query.setFirstResult(beginIndex);
				query.setMaxResults(pageSize);
				return query.list();
			}
			
		});
		return list;
	}

}
