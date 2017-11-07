package dps.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import dps.bean.MyClass;
import dps.bean.Student;
import dps.util.HibernateSessionFactory;

public class hibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		hibernateTest test = new hibernateTest();
		test.OpSqlTest3();
	}
	//使用SQL查询年所有学生的名字
		public void OpSqlTest()
		{
			Session session = HibernateSessionFactory.getSession();
				List<Student> myList = session.createSQLQuery("select * from t_student")
				             //可以通过addScalar方法来明确指定返回值的数据类型
			                                .addScalar("name",StandardBasicTypes.STRING)
						                        .list();
		  		System.out.println(myList);

			HibernateSessionFactory.closeSession();
		}
		//使用SQL查询所有学生实体
		public void OpSqlTest2()
		{
			Session session = HibernateSessionFactory.getSession();
			List<Student> myList = session.createSQLQuery("select * from t_student")
                    //指定查询的记录转换成Student实体
		                               .addEntity(Student.class)
		                               .list();
		 for(Student s:myList)
		 {
		System.out.println(s.getSname()+"的学号是："+s.getSnum());
		 }

			HibernateSessionFactory.closeSession();
		}
		//使用SQL查询
		public void OpSqlTest3()
		{
			Session session = HibernateSessionFactory.getSession();
			List myList = session.createSQLQuery("select {s.*} ,{c.*} from t_student s,t_myclass c where s.c_id=c.cid")
					//指定查询的记录转换成Student实体和MyClass实体                           
					.addEntity("s",Student.class)
					.addEntity("c",MyClass.class)
			          .list();		
					for(Object u:myList)
					{
						Object[] uu= (Object[])u;
						Student s=(Student) uu[0];
						MyClass   c= (MyClass) uu[1];
						System.out.println(s.getSname()+"的班级名字是："+c.getCname());
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
