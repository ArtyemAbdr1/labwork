package Lab1;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class info extends JFrame  {
	private JLabel label = new JLabel("GitHub");
	private JLabel label2 = new JLabel("GitHub - крупнейший веб-сервис для хостинга IT-проектов и их совместной разработки.");
	public info() {
	super("Информация");
	this.setBounds(700,700,600,150);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container container = this.getContentPane();
	container.setLayout(new GridLayout(6,2,2,2));
	container.add(label);
	container.add(label2);
}}