package dps.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dps.bean.User;

public class hibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory  sf = null;
		Session session = null;
		Configuration cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User("张三","12345",20,"男",new Date());
		session.save(user);
		tx.commit();
		System.out.println("添加用户成功！");
	}
}
