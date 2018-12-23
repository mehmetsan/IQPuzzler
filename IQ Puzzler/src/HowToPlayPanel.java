import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HowToPlayPanel extends JPanel {
	private GameOfObjectsMenu menu;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public HowToPlayPanel(GameOfObjectsMenu x) {
		setLayout(null);
		menu = x;
		setBackground(new Color(8,178 ,227));
		JLabel label = new JLabel("How To Play");
		//label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 35));
		label.setBounds(20, 25, 240, 45);
		label.setForeground(Color.ORANGE);
		add(label);

		JButton back = new JButton("Back");
		//btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		back.setBounds(120, 780, 200, 60);
		back.setBackground(new Color(59, 89, 182));
		back.setForeground(Color.WHITE);
		back.setFocusPainted(false);
		back.setFont(new Font("Tahoma", Font.BOLD, 25));
		back.addActionListener(new backListener());
		add(back);

		JLabel label2 = new JLabel("<html><p>"+ "\t" +"Select a mode. Then ,choose a challenge."
				+ "You can choose singleplayer and multiplayer mode.Select casual or time bomb mode."
				+"In casual mode game is simple."
				+ " Place the puzzle pieces as indicated. "
				+ "You are not allowed to change the position of the pieces given in the challenge."
				+ "Try to fill the empty spaces with all the remaining puzzle pieces."
				+ "TimeBomb mode is similar to the casual mode. But this time you have to beat before time ends."
				+"In the multiplayer mode, you can play with your friend and each player have their own time. Play swift!"
				+ "There is only one solution per challenge(after level 3). "
				+ "You can show solution if you stuck."
				+ "Have fun!<html><p>");
		//label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label2.setForeground(Color.ORANGE);
		label2.setBounds(20, 80, 550, 730);
		add(label2);


	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		ImageIcon img;
		img = new ImageIcon("background.jpg");
		img.paintIcon(null, g, 0, 0);
	}

	public class backListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			setVisible(false);
			MainPanel m = new MainPanel(menu);
			menu.show(m);

		}	

	}
}