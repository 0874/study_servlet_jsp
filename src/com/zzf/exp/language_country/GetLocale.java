package com.zzf.exp.language_country;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/g_locale")
public class GetLocale extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		Locale locale = req.getLocale();
		String language = locale.getLanguage();
		String country = locale.getCountry();
		req.setAttribute("la", language);
		req.setAttribute("co", country);
		resp.setContentType("text/html;charset=utf-8");
		resp.setHeader("Content-Language", "zh");//设置中文代码
		req.getRequestDispatcher("page/locale/1.jsp").forward(req, resp);
	}
}
