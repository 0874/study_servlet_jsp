package com.zzf.exp.language_country;
////当地货币设置
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/location_time")
public class LocationTimeFormat extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		resp.setContentType("text/html;utf-8");
		Locale locale = req.getLocale();
		String date = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.SHORT,locale).format(new Date());
		req.setAttribute("l_t", date);
		
		//========================================================
		NumberFormat format = NumberFormat.getCurrencyInstance(locale);
		String a = format.format(10000);
		req.setAttribute("money_10000",a );
		
		//=============================================
		NumberFormat format2 = NumberFormat.getPercentInstance(locale);
		String b = format2.format(10000);
		req.setAttribute("percent", b);
		req.getRequestDispatcher("page/locale/2.jsp").forward(req, resp);
	}
}
