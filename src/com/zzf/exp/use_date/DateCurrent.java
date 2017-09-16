package com.zzf.exp.use_date;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/my_date")
public class DateCurrent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		resp.setContentType("text/html;utf-8");
		req.setAttribute("date", new Date());
		req.setAttribute("d2", new SimpleDateFormat("yyyy.MM.dd hh:mm:ss E a").format(new Date()));
		req.getRequestDispatcher("page/date/mydate.jsp").forward(req, resp);
	}
}
/*
字符	描述	实例
G	Era 指示器	AD
y	四位数表示的年	2001
M	一年中的月	July 或 07
d	一月中的第几天	10
h	带有 A.M./P.M. 的小时（1~12）	12
H	一天中的第几小时（0~23）	22
m	一小时中的第几分	30
s	一分中的第几秒	55
S	毫秒	234
E	一周中的星期几	Tuesday
D	一年中的第几天	360
F	所在的周是这个月的第几周	2 (second Wed. in July)
w	一年中的第几周	40
W	一月中的第几周	1
a	A.M./P.M. 标记	PM
k	一天中的第几小时（1~24）	24
K	带有 A.M./P.M. 的小时（0~11）	10
z	时区	Eastern Standard Time
'	Escape for text	Delimiter
"	单引号	`*/