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
		test.OpHqlTest2();
	}
	//使用HQL查询年龄小于21岁的学生记录--位置参数
		public void OpHqlTest()
		{
			Session session = HibernateSessionFactory.getSession();
			String strHQl = "from Student s where s.sage<? ";
			List<Student> myList = session.createQuery(strHQl).setParameter(0, 21).list();
			for(Student s:myList)
			{
				System.out.println(s);
			}
			HibernateSessionFactory.closeSession();
		}
		//使用HQL查询年龄小于21岁的学生记录--命名参数
		public void OpHqlTest2()
		{
			Session session = HibernateSessionFactory.getSession();
			String strHQl = "from Student s where s.sage<:age ";
			List<Student> myList = session.createQuery(strHQl).setParameter("age", 21).list();
			for(Student s:myList)
			{
				System.out.println(s);
			}
			HibernateSessionFactory.closeSession();
		}
	
	
	//向数据库中添加记录
	public void OpAdd()
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Student s1 = new Student("2014123001", "学生1", 20, new Date());
		Student s2 = new Student("2014123002", "学生2", 19, new Date());
		Student s3 = new Student("2014123003", "学生3", 21, new Date());
		Student s4 = new Student("2014123004", "学生4", 20, new Date());
		Student s5 = new Student("2014123005", "学生5", 24, new Date());
		Student s6 = new Student("2014123006", "学生6", 20, new Date());
		Student s7 = new Student("2014123007", "学生7", 22, new Date());
		MyClass myClass = new MyClass("2014Java专业 ");
		s1.setMyClass(myClass);
		s2.setMyClass(myClass);
		s3.setMyClass(myClass);
		s4.setMyClass(myClass);
		s5.setMyClass(myClass);
		s6.setMyClass(myClass);
		s7.setMyClass(myClass);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		session.save(s6);
		session.save(s7);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	
}
