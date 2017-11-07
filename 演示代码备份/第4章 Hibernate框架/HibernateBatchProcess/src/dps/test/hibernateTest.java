package dps.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dps.bean.MyClass;
import dps.bean.Student;
import dps.util.HibernateSessionFactory;

public class hibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		hibernateTest test = new hibernateTest();
		test.addManyStudents();
	}
	//批处理之添加多条学生记录--会出现一级缓存溢出
		public void addManyStudents()
		{
			Session session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			for(int i=0;i<1000000;i++)
			{
				//产生一个15到25的随机年龄
				 int age  =  (int)(Math.random()*10+16);
			     Student s = new Student("2014"+i, "学生"+i, age, new Date());
			     session.save(s);
			}
			session.getTransaction().commit();
			HibernateSessionFactory.closeSession();
		}
		//批处理之添加多条学生记录--不会一级缓存溢出
		public void addManyStudents2()
		{
			Session session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			for(int i=0;i<1000000;i++)
			{
				//产生一个15到25的随机年龄
				int age  =  (int)(Math.random()*10+16);
				Student s = new Student("2014"+i, "学生"+i, age, new Date());
				session.save(s);
				//定时手动刷新并且清空一级缓存
				if(i%1000==0) { session.flush();session.clear();}
			}
			session.getTransaction().commit();
			HibernateSessionFactory.closeSession();
		}
		//批处理之更新多条学生记录
		public void updateManyStudents()
		{
			Session session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			String strHql= "update Student set age =age+1 ";
			int count = session.createQuery(strHql).executeUpdate();
			System.out.println("更行数据库的记录数为："+count);
			session.getTransaction().commit();
			HibernateSessionFactory.closeSession();
		}
		//批处理之删除多条学生记录
		public void deteteManyStudents()
		{
			Session session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			String strHql= "delete Student";
			int count = session.createQuery(strHql).executeUpdate();
			System.out.println("删除数据库的记录数为："+count);
			session.getTransaction().commit();
			HibernateSessionFactory.closeSession();
		}
}
