package Lab1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import java.awt.Desktop;


public class io extends JFrame {
	
private JLabel labelbttn = new JLabel("кнопка информации добавлена");
private JTextField input = new JTextField("");
private JButton button = new JButton("Рассчитать м^3");
private JButton buttonsm = new JButton("Рассчитать cм^3");
private JButton button2 = new JButton("Мнемосхема");
private JButton buttoninfo = new JButton("Информация");
private JLabel label = new JLabel("ПИ-320");
private JLabel labelFGB = new JLabel("ФГБОУ ВО");
private JLabel label2 = new JLabel("Абрашитов Артём Маратович");
private JLabel label3 = new JLabel();
private JLabel labelUSATU = new JLabel("Уфимский государственный авиационный технический университет");
public io() {
super("Simple Example");
this.setBounds(700,700,400,300);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
button.addActionListener(new ButtonEventListener());
button2.addActionListener(new SecondEventListener());
buttoninfo.addActionListener(new infoopen());
buttonsm.addActionListener(new SMB());
setContentPane(new BgPanel());
Container container = this.getContentPane();
container.setLayout(new GridLayout(12,2,2,2));
container.add(labelUSATU);
container.add(labelFGB);
container.add(label);
container.add(label2);
container.add(input);
container.add(button);
container.add(buttonsm);
container.add(button2);
container.add(label3);
container.add(labelbttn);
container.add(buttoninfo);
JLabel txtBrowserURILabel;
txtBrowserURILabel = new JLabel("asu.ugatu.ac.ru/index.php");
txtBrowserURILabel.setBounds(260, 170, 150, 30);
txtBrowserURILabel.setForeground(Color.blue);
txtBrowserURILabel.setFont(new Font("Arial", Font.BOLD, 12));

MouseListener listener = new LinkMouseListener();
txtBrowserURILabel.addMouseListener(listener);

txtBrowserURILabel.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			launchBrowser(txtBrowserURILabel.getText());
		}
	}
});

add(txtBrowserURILabel);
}

class LinkMouseListener extends MouseAdapter {
public void mouseEntered(MouseEvent e) {
	if (!(e.getSource() instanceof JLabel)) {
		return;
	}
	JLabel label = (JLabel) e.getSource();
	label.setForeground(Color.RED);
	Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
	label.setCursor(cursor);
}

@Override
public void mouseExited(MouseEvent e) {
	if (!(e.getSource() instanceof JLabel)) {
		return;
	}
	JLabel label = (JLabel) e.getSource();
	label.setForeground(Color.BLUE);
}
}

//launch browser
private void launchBrowser(String uriStr) {
Desktop desktop;
if (Desktop.isDesktopSupported()) {
	desktop = Desktop.getDesktop();
	if (desktop.isSupported(Desktop.Action.BROWSE)) {
//launch browser
		URI uri;
		try {
			uri = new URI("http://" + uriStr);
			desktop.browse(uri);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (URISyntaxException use) {
			use.printStackTrace();
		}
	}
}
}
class ButtonEventListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		double value = (7*Integer.parseInt(input.getText())*40);
		label3.setText("Объем параллелограмма = "+value/1000+"м^3");
	}
}
class infoopen implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		info app = new info();
		app.setVisible(true);
	}
}
class SMB implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		double value = (70*Integer.parseInt(input.getText())*400);
		label3.setText("Объем параллелограмма = "+value+"cм^3");
	}
}
class SecondEventListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		File jpgFile = new File("src/Lab1/mnemo.jpg");
        if (jpgFile.exists()) {
            if (Desktop.isDesktopSupported()) {
                try {
					Desktop.getDesktop().open(jpgFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } else {
                System.out.println("Awt Desktop is not supported!");
            }
 
        } else {
            System.out.println("File is not exists!");
        }
	}
}
public static void main(String[] args) {
io app = new io();
app.setVisible(true);
}

class BgPanel extends JPanel{
public void paintComponent(Graphics g){
Image im = null;
try {
im = ImageIO.read(new File("src/Lab1/logo.jpg"));
} catch (IOException e) {}
g.drawImage(im, 205,0, null);
}
}
}