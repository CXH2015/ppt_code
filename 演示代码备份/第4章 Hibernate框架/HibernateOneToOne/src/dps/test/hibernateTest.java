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
		test.OpOneToOne();
	}
	//一对一操作
	public void OpOneToOne()
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Student s1 = new Student("2014123001", "学生1", 20, new Date());
		MyClass myClass = new MyClass("2014Java专业 ");
		s1.setMyClass(myClass);
		session.save(s1);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	//一对一操作,会出现异常
	public void OpOneToOne2()
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Student s1 = new Student("2014123001", "学生1", 20, new Date());
		Student s2 = new Student("2014123001", "学生1", 20, new Date());
		MyClass myClass = new MyClass("2014Java专业 ");
		s1.setMyClass(myClass);
		s2.setMyClass(myClass);
		session.save(s1);
		session.save(s2);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	
}
