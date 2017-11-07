package dps.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport {
	
	private String username;
	private File myUpload;
	private String myUploadFileName;
	private String myUploadContentType;
	private String savePath;
	//接受struts.xml文件配置值的方法
	public void setSavePath(String value)
	{
		this.savePath = value;
	}
	//返回上传文件的保存位置
	public String getSavePath() throws Exception 
	{
		String  str = ServletActionContext.getServletContext()
				.getRealPath(savePath);
		return str;
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public File getMyUpload() {
		return myUpload;
	}


	public void setMyUpload(File myUpload) {
		this.myUpload = myUpload;
	}


	public String getMyUploadFileName() {
		return myUploadFileName;
	}


	public void setMyUploadFileName(String myUploadFileName) {
		this.myUploadFileName = myUploadFileName;
	}


	public String getMyUploadContentType() {
		return myUploadContentType;
	}


	public void setMyUploadContentType(String myUploadContentType) {
		this.myUploadContentType = myUploadContentType;
	}


	// 文件上传的action方法 
	public String upload() throws Exception {
		String strNewFileName = UUID.randomUUID().toString();
		String suffix = myUploadFileName.substring(myUploadFileName.lastIndexOf("."));
		strNewFileName+=suffix;
		//以服务器的文件保存地址和原文件名建立上传文件输出流
		FileOutputStream fos = new FileOutputStream(getSavePath()
			+ "\\" + strNewFileName);
		myUploadFileName = strNewFileName;
		FileInputStream fis = new FileInputStream(getMyUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0)
		{
			fos.write(buffer , 0 , len);
		}
		fos.close();
		return SUCCESS;
	}

}
