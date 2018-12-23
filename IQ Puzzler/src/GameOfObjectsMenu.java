import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.lang.*;

public class GameOfObjectsMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private MainPanel main;
	public GameOfObjectsMenu() {
		
	    
		main = new MainPanel(this);
		setName("GameOfObjects");		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("IQ Puzzler");
		add(main);
	}
      public void show(JPanel panel){
        	getContentPane().removeAll();
        	add(panel);
        }
      
    

	public class exitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit((0));
		}	

	}
        
	public static void main(String[] args) {
		new GameOfObjectsMenu();
	}
}
