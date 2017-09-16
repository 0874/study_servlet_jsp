package com.zzf.exp.cookie;
//删除cookie,cookie.setMaxAge(0),resp.addCookie(cookie);
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/helloCookie")
public class HelloFormCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		Cookie name = new Cookie("name", URLEncoder.encode("我的名字", "utf-8")	);
		Cookie url = new Cookie("url", req.getParameter("url"));
		name.setMaxAge(20);//20s
		url.setMaxAge(30);
		resp.addCookie(name);
		resp.addCookie(url);
		resp.setContentType("text/html;charset=utf-8");
		req.getRequestDispatcher("page/cookie/1.jsp").forward(req, resp);	
	}
}
