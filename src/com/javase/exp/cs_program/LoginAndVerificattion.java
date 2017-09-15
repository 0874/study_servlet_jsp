package com.javase.exp.cs_program;
///1.这个类里的getter方法，不是访问原来的对象，而是生成新的，本来可以用个初始化的方法，怕麻烦
import java.awt.Color;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginAndVerificattion extends JFrame {
	
	private String userName;
	private String password;
	private JPanel jPanelLogin;
	private JLabel jLabelUserName;
	private JLabel jLabelPassword;
	private JTextField jTextFieldName;
	private JTextField jTextFieldPassword;
	private JButton jButtonLogin ;
	private JTextArea jTextAreaLog;
	private JScrollPane jPanelScroll;
	private Font font1 = new Font("楷体", Font.ITALIC, 28);
	/**
	 * 
	 */
	private static final long serialVersionUID = 6275619665236984927L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginAndVerificattion();
	}
	public String doLogin() {//与服务器交互并返回结果
		return null;
	}
	private  void listenToWidget() {//假设，输入符合规范，
		System.out.println("进行事件监听...");
		this.jButtonLogin.addActionListener(new ActionListener() {//这个没用函数式
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jTextAreaLog.append("you_点击了登录::{"+userName+"}::{"+password+"}\n");
				String result = doLogin();
				jTextAreaLog.append("server:"+result+"\n");
			}
		});
		this.jTextFieldName.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
//				System.out.println("00:"+(
						userName = jTextFieldName.getText();
//						));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.jTextFieldPassword.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				password = jTextFieldPassword.getText();
			}
		});
	}
	public LoginAndVerificattion() throws HeadlessException {
//		super();
		// TODO Auto-generated constructor stub
		initWindow();
	}
	private void initWindow() {
		System.out.println("正在初始：：窗口样式");
		this.setTitle("login");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		decorateWindow();
		this.setVisible(true);
	}
	private void decorateWindow() {
		this.add(getjPanelLogin());
		jPanelLogin.setLayout(null);
		jPanelLogin.setFont(font1);
		jPanelLogin.add(getjLabelUserName());
		jLabelUserName.setBounds(50, 50, 200, 30);
		jPanelLogin.add(getjLabelPassword());
		jLabelPassword.setBounds(50, 100, 200, 30);
		jPanelLogin.add(getjTextFieldName());
		jPanelLogin.add(getjTextFieldPassword());
		jTextFieldName.setBounds(250, 50, 200, 32);
		jTextFieldName.setFont(font1);
		jTextFieldPassword.setBounds(250, 100, 200, 32);
		jTextFieldPassword.setFont(font1);
		this.jPanelLogin.add(getjButtonLogin());
		this.jButtonLogin.setBounds(610, 400, 100, 30);
		this.jPanelLogin.add(getjPanelScroll());
		this.jPanelScroll.setViewportView(getjTextAreaLog());
		this.jPanelScroll.setBounds(0, 135, 600, 450);
		this.jTextAreaLog.setFont(new Font("楷体", Font.BOLD, 15));
		this.jTextAreaLog.setLineWrap(false	);
		this.jTextAreaLog.setWrapStyleWord(true);
		jTextAreaLog.setEditable(false);
		listenToWidget();
	}
//==========================================下面是生成的访问器=============也有后加的=====================
	
	
	
	public String getUserName() {
		return userName;
	}

	/*public JPanel getjPanelScroll() {
		this.jPanelScroll = new JPanel();
		return jPanelScroll;
	}

	public void setjPanelScroll(JPanel jPanelScroll) {
		this.jPanelScroll = jPanelScroll;
	}*/
	
	public JTextArea getjTextAreaLog() {
		this.jTextAreaLog = new JTextArea(10, 20);
		return jTextAreaLog;
	}

	public JScrollPane getjPanelScroll() {
		this.jPanelScroll = new JScrollPane();
		return jPanelScroll;
	}

	public void setjPanelScroll(JScrollPane jPanelScroll) {
		this.jPanelScroll = jPanelScroll;
	}

	public void setjTextAreaLog(JTextArea jTextAreaLog) {
		this.jTextAreaLog = jTextAreaLog;
	}

	public JButton getjButtonLogin() {
		this.jButtonLogin = new JButton("立即登录");
		return jButtonLogin;
	}

	public void setjButtonLogin(JButton jButtonLogin) {
		this.jButtonLogin = jButtonLogin;
	}

	public JTextField getjTextFieldName() {
		this.jTextFieldName = new JTextField();
		return jTextFieldName;
	}

	public void setjTextFieldName(JTextField jTextFieldName) {
		this.jTextFieldName = jTextFieldName;
	}

	public JTextField getjTextFieldPassword() {
		this.jTextFieldPassword = new JTextField();
		return jTextFieldPassword;
	}

	public void setjTextFieldPassword(JTextField jTextFieldPassword) {
		this.jTextFieldPassword = jTextFieldPassword;
	}

	public JLabel getjLabelUserName() {
		this.jLabelUserName = new JLabel("用户名：");
		this.jLabelUserName.setFont(font1);
		return jLabelUserName;
	}

	public void setjLabelUserName(JLabel jLabelUserName) {
		this.jLabelUserName = jLabelUserName;
	}

	public JLabel getjLabelPassword() {
		this.jLabelPassword = new JLabel("密码：");
		jLabelPassword.setFont(font1);
		return jLabelPassword;
	}

	public void setjLabelPassword(JLabel jLabelPassword) {
		this.jLabelPassword = jLabelPassword;
	}

	public JLabel getjLabel() {
		return jLabelUserName;
	}

	public void setjLabel(JLabel jLabel) {
		this.jLabelUserName = jLabel;
	}

	public JPanel getjPanelLogin() {
		this.jPanelLogin = new JPanel();
		jPanelLogin.setBackground(Color.BLUE);
		return jPanelLogin;
	}

	public void setjPanelLogin(JPanel jPanelLogin) {
		this.jPanelLogin = jPanelLogin;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
