package dps.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class CreateTables {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//读取hibernate.cfg.xml配置文件
		Configuration cfg =new Configuration().configure();
		SchemaExport export = new SchemaExport(cfg); 
		//生成数据库表
		export.create(true, true);
	}

}
