package com.zzf.exp.email_host;
/////这个发送没有效果啊，既不提示错误。应该本地不支持发送吧：http://www.runoob.com/servlet/servlet-sending-email.html
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/sendMail")
public class SendEmailFromHost extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4832942980265726827L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String to = "1147057783@qq.com";
		String from = "3453539748@qq.com";
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		resp.setContentType("text/html;charset=utf-8");
		@SuppressWarnings("unused")
		PrintWriter printWriter = resp.getWriter();
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("这是servlet邮件");
			message.setText("我是正文");
			Transport.send(message);
			req.getRequestDispatcher("/page/email_servlet/1.html").forward(req, resp);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("这个邮件还是用servlet发送的.");
	}

}
