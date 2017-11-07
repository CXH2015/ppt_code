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
		test.OpManyToOne();
	}
	//多对一操作
	public void OpManyToOne()
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Student s1 = new Student("2014123001", "学生1", 20, new Date());
		Student s2 = new Student("2014123002", "学生2", 19, new Date());
		Student s3 = new Student("2014123003", "学生3", 21, new Date());
		Student s4 = new Student("2014123004", "学生4", 20, new Date());
		MyClass myClass = new MyClass("2014Java专业 ");
		s1.setMyClass(myClass);
		s2.setMyClass(myClass);
		s3.setMyClass(myClass);
		s4.setMyClass(myClass);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	
}
