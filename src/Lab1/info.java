package Lab1;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class info extends JFrame  {
	private JLabel label = new JLabel("��-320");
	private JLabel labelFGB = new JLabel("����� ��");
	private JLabel label2 = new JLabel("��������� ���� ���������");
	private JLabel labelUSATU = new JLabel("�������� ��������������� ����������� ����������� �����������");
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
