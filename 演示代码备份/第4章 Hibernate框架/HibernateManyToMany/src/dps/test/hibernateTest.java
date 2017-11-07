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
		test.OpManyToMany();
	}
	//多对多操作
	public void OpManyToMany()
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Student s1 = new Student("2014123001", "学生1", 20, new Date());
		Student s2 = new Student("2014123002", "学生2", 19, new Date());
		MyClass myClass1 = new MyClass("2014Java专业 ");
		MyClass myClass2 = new MyClass("2014Java专业 ");
		Set<Student> mySet = new HashSet<Student>();
		mySet.add(s1);
		mySet.add(s2);
		myClass1.setMyStudentSet(mySet);
		myClass2.setMyStudentSet(mySet);
		session.save(myClass1);
		session.save(myClass2);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
}
