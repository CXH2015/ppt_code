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
		test.OpOneToMany();
	}
	//一对多操作
	public void OpOneToMany()
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Student s1 = new Student("2014123001", "学生1", 20, new Date());
		Student s2 = new Student("2014123002", "学生2", 19, new Date());
		Student s3 = new Student("2014123003", "学生3", 21, new Date());
		Student s4 = new Student("2014123004", "学生4", 20, new Date());
		MyClass myClass = new MyClass("2014Java专业 ");
		Set<Student> mySet = new HashSet<Student>();
		mySet.add(s1);
		mySet.add(s2);
		mySet.add(s3);
		mySet.add(s4);
		myClass.setMyStudentSet(mySet);
		session.save(myClass);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
}
