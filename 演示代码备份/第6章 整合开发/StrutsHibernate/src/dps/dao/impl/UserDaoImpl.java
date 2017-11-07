package dps.dao.impl;

import java.util.List;

import org.hibernate.Session;

import dps.bean.User;
import dps.dao.UserDao;
import dps.page.Pager;
import dps.util.HibernateSessionFactory;

public class UserDaoImpl implements UserDao {
	@Override
	public void save(User u) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
	@Override
	public boolean loginCheck(String name, String password) {
		boolean returnValue = false;
		String strHql = "select count(*) from User u where u.uname=:name and" +
				" u.upassword=:password";
		Session session = HibernateSessionFactory.getSession();
		Object obj = session.createQuery(strHql)
												.setParameter("name", name)
												.setParameter("password", password)
												.list()
												.iterator()
												.next();
		System.out.println("obj ="+obj);
		Long count = obj==null?0:(Long)obj;
		if(count>0)
			returnValue = true;
		HibernateSessionFactory.closeSession();
		System.out.println("returnValue = "+returnValue);
		return returnValue;
	}

	@Override
	public List<User> selectAllUser() {
		Session session = HibernateSessionFactory.getSession();
		List<User> myList = session.createQuery("from User").list();
		HibernateSessionFactory.closeSession();
		return myList;
	}

	@Override
	public List<User> selectAllUserPage(Pager page) {
		Session session = HibernateSessionFactory.getSession();
		List<User> myList = session.createQuery("from User")
														.setFirstResult(page.getStartRow())
														.setMaxResults(page.getPageSize())
														.list();
		HibernateSessionFactory.closeSession();
		return myList;
	}

	@Override
	public int getTotalRows() {
		Session session = HibernateSessionFactory.getSession();
		int totalRows = 0;
		String strHql  = "select count(*) from User";
		Object obj = session.createQuery(strHql)
											.list().iterator().next();
		if(obj!=null)
		   totalRows = Integer.parseInt(obj.toString());
		HibernateSessionFactory.closeSession();
		return totalRows;
	}

	@Override
	public List<User> searchUserPage(Pager page, String searchType,
			String searchValue) {
		String strHql = "";
		//根据用户名查询
		if(searchType.equals("1"))
		{
			strHql = "from User u where u.uname  like ? ";
		}
		//根据性别查询
		if(searchType.equals("2"))
		{
			strHql = "from User u where u.ugender like ? ";
		}
		//
		Session session = HibernateSessionFactory.getSession();
		List<User> myList = session.createQuery(strHql)
														.setParameter(0, "%"+searchValue+"%")
														.setFirstResult(page.getStartRow())
														.setMaxResults(page.getPageSize())
														.list();
		HibernateSessionFactory.closeSession();
		return myList;
	}

	@Override
	public int getSearchRows(String searchType, String searchValue) {
		Session session = HibernateSessionFactory.getSession();
		int totalRows = 0;
		String strHql = "";
		//根据用户名查询
		if(searchType.equals("1"))
		{
			strHql = "select count(*)  from User u where u.uname like ? ";
		}
		//根据性别查询
		if(searchType.equals("2"))
		{
			strHql = "select count(*)  from User u where u.ugender like ? ";
		}
		Object obj = session.createQuery(strHql)
											.setParameter(0, "%"+searchValue+"%")
											.list().iterator().next();
		if(obj!=null)
		   totalRows = Integer.parseInt(obj.toString());
		HibernateSessionFactory.closeSession();
		return totalRows;
	}

	@Override
	public User get(Object uid) {
		Session session = HibernateSessionFactory.getSession();
		Integer id = Integer.valueOf(uid.toString());
		User u = (User) session.get(User.class, id); 
		HibernateSessionFactory.closeSession();
		return u;
	}

	@Override
	public void update(User u) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.update(u);
		session.getTransaction().commit();
		HibernateSessionFactory.closeSession();
		
	}
	@Override
	public void delete(User u) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.delete(u);
		session.getTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
