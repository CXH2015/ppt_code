package dps.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
/*
 * 生成数据库--测试使用
 */
public class CreateTables {
	public static void main(String[] args) {
		Configuration cfg =new AnnotationConfiguration().configure();
		SchemaExport export = new SchemaExport(cfg); 
		export.create(true, true);
	}
}
