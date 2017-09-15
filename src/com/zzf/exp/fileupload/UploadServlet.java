package com.zzf.exp.fileupload;
//上传成功，就是在开发时，路径默认时以运行时的文件为准，但这又被eclipse设为隐藏，所以得自己找找
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/*import org.apache.tomcat.util.http.fileupload.FileItem;这些包类不对，需要用commen....那个，http://www.runoob.com/servlet/servlet-file-uploading.html
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;*/

public class UploadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2621137518665120894L;
	private String fileStoreDir ="upload" ;
	private int memory_threshold = 1024*1024*3;//3m,存储门槛？
	private int file_max = 1024*1024*40;//
	private int max_request = 1024*1024*50;//
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		boolean isMultiMedia = ServletFileUpload.isMultipartContent(req);
		if(isMultiMedia)
			System.out.println("是，多媒体上传。");
		else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("表单属性没有包含enctype='multipart/form-data'");
			printWriter.flush();
			return ;
		}
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setSizeThreshold(memory_threshold);//设置内存临界值，上传文件大小超过这个时会产生临时文件并存储在临时目录中
		diskFileItemFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));//找到临时目录
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setFileSizeMax(file_max);
		servletFileUpload.setSizeMax(max_request);
		servletFileUpload.setHeaderEncoding("UTF-8");
		String uploadPath = req.getServletContext().getRealPath("/")+/*File.separator+*/fileStoreDir;//这个多了一个斜杠
		File uploadDir = new File(uploadPath);
		if(uploadDir.exists())
			System.out.println("目录已经存在");
		else
			uploadDir.mkdir();
		try {
			List<FileItem> formsItem = servletFileUpload.parseRequest(req);
			if(formsItem!=null && formsItem.size()>0) {
				for(FileItem fileItem:formsItem) {
					if(fileItem.isFormField()) {
						System.out.println("这个字段在表单中:"+fileItem.getFieldName());
					}else {
						String name = new File(fileItem.getName()).getName();
						System.out.println("uploadPath:"+uploadPath);
						String filePath = uploadPath+File.separator+name;
						File storeF = new File(filePath);
						System.out.println("硬盘文件路径："+filePath);
						fileItem.write(storeF);
						req.setAttribute("msg", "文件上传成功");
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getServletContext().getRequestDispatcher("/").forward(req, resp);
	}
}
