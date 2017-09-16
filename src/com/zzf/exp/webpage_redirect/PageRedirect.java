package com.zzf.exp.webpage_redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/page_redirect")
public class PageRedirect extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		resp.setContentType("text/html;charset=UTF-8");
		String site = new String("http://www.baidu.com");
		resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);//临时移动？
		resp.setHeader("location", site);
	}
}
