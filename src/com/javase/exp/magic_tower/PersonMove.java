package com.javase.exp.magic_tower;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PersonMove {
	
	private JFrame frame;
	private JPanel panelGround = new JPanel();
	private JLabel labelPerson = new JLabel("人");
	
	public PersonMove(JFrame frame) {
		super();
		this.frame = frame;
		// TODO Auto-generated constructor stub
		init();
	}
	private void init() {
		this.frame.add(panelGround);
		this.panelGround.setLayout(null);
		this.panelGround.add(labelPerson);
		this.labelPerson.setBounds(0, 0, 10, 10);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
}
