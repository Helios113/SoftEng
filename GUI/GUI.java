package GUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Font;
public class GUI extends JFrame implements ActionListener {
	Container cPane;
	CardLayout cardLayout;
	JPanel cards;
	// Attributes
	final int HEIGHT = 350;
	final int WIDTH = HEIGHT * 2;
	DirectorView dv;
	JPanel iv;

	public GUI() {  
		
		cPane = getContentPane();    
		cardLayout =new CardLayout(40,30);    
		cPane.setLayout(cardLayout);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set title
		this.setTitle("GUI Table");
		
		iv = new InitialView(this);
		cPane.add(iv, "Test1");
		dv = new DirectorView(this);
		cPane.add(dv, "Director");
		
		
	}
	public void showGUI() {
		//setting to visible
		setVisible(true);	
	}
	public void actionPerformed(ActionEvent e){  
		switch (e.getActionCommand())
		{
			case "Director":
				cardLayout.show(cPane, "Director");
				break;
			case "Return":
				cardLayout.show(cPane, "Test1");
				break;

		}
    }
	
}