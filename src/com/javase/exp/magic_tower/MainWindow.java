package com.javase.exp.magic_tower;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private JPanel panelGround = new JPanel();
	private static final long serialVersionUID = 6603484301024371724L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainWindow();
	}
	public MainWindow() {
		// TODO Auto-generated constructor stub
		initWindow();
	}
	private void initWindow() {
		this.setTitle("magic tower");
		this.setSize(800, 600);//这个设置大小和定位有先后关系
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new PersonMove(this);
		this.setVisible(true);
	}
	
}
