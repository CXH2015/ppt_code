package dps.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dps.bean.IPerson;

public class SpringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 读取Spring配置文件
		ApplicationContext act =new     ClassPathXmlApplicationContext("applicationContext.xml");
		//从Spring容器中获取id为p1的bean
		IPerson chinese=act.getBean("chinese",IPerson.class);
		chinese.sayHello();
		chinese.drink();
	}
}
