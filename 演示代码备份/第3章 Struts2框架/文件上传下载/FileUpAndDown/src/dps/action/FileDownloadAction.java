package dps.action;

import java.io.InputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.*;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class FileDownloadAction
	extends ActionSupport 
{
	private String inputPath;
	public void setInputPath(String value)
	{
		inputPath = value;
	}
	public InputStream getTargetFile() throws Exception 
	{
		return ServletActionContext.getServletContext()
			.getResourceAsStream(inputPath);
	}
}
