package Lab1;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class info extends JFrame  {
	private JLabel label = new JLabel("ПИ-320");
	private JLabel labelFGB = new JLabel("ФГБОУ ВО");
	private JLabel label2 = new JLabel("Абрашитов Артём Маратович");
	private JLabel labelUSATU = new JLabel("Уфимский государственный авиационный технический университет");
	public info() {
	super("Simple Example");
	this.setBounds(700,700,400,300);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container container = this.getContentPane();
	container.setLayout(new GridLayout(12,2,2,2));
	container.add(labelUSATU);
	container.add(labelFGB);
	container.add(label);
	container.add(label2);
}}
