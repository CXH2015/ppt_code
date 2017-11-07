package dps.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import dps.bean.MyClass;
import dps.bean.Student;
import dps.util.HibernateSessionFactory;

public class MyTest3 {
public static void main(String[] args) {
	Session session  = HibernateSessionFactory.getSession();
	Student s1 = new Student("2011123456", "王菲1", 30, new Date());
	Student s2 = new Student("2011123123", "王菲2", 37, new Date());
	Student s3 = new Student("2011123128", "王菲3", 38, new Date());
	Student s4 = new Student("2011123453", "王菲4", 33, new Date());
	MyClass myClass = new MyClass("2011金融专业 ");
	Set<Student> mySet = new HashSet<Student>();
	mySet.add(s1);
	mySet.add(s2);
	mySet.add(s3);
	mySet.add(s4);
	
	myClass.setMyStudentSet(mySet);
//	s1.setMyClass(myClass);
//	s2.setMyClass(myClass);
	
	session.beginTransaction();
	
	//通过班级来操作学生---1-N
//	myClass = (MyClass) session.get(MyClass.class,1);
//	Set<Student> set2 = myClass.getMyStudentSet();
//	for(Student s:set2)
//	{
//		System.out.println(s.getSname());
//	}
	
	session.save(s1);
	session.save(s2);
	session.save(s3);
	session.save(s4);
//	session.save(myClass);
	
	//session.save(myClass);
//	session.save(s1);
//	session.save(s2);
//	s1.setMyClass(myClass);
//	s2.setMyClass(myClass);
	//通过学生操作班级  --N-1
//	s1 = (Student) session.get(Student.class, 3);
//	System.out.println(s1.getMyClass().getCname());
//	session.delete(s1);
//	MyClass mc = session.get
	session.getTransaction().commit();
	
	HibernateSessionFactory.closeSession();
}
}
