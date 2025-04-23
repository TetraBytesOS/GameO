package univerisdadProgramacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Marcos extends JFrame{
	
	Toolkit miToolkit=Toolkit.getDefaultToolkit();
	
	public Marcos() {
		setBounds(0,0,miToolkit.getScreenSize().width,(miToolkit.getScreenSize().height-330));
		setAlwaysOnTop(true);
		setResizable(false);
		Paneles miPanel=new Paneles();
		add(miPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
}

class Paneles extends JPanel{
	
	public Paneles() {
		setBackground(Color.BLACK);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			Graphics2D g2=(Graphics2D)g;
			g2.setPaint(Color.WHITE);
			g2.setFont(new Font("Comic Sans MS",0,20));
			g2.drawString(Textos.getTexto(),10,40);
			g2.drawImage(Imagenes.getImagen(),600,200, 250, 250,null);
		
	}
	
}
