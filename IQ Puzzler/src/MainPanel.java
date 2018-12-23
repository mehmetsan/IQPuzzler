import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;

import javax.swing.ImageIcon;

public class MainPanel extends JPanel {

	private GameOfObjectsMenu menu;
	
	public MainPanel(GameOfObjectsMenu x)
	{
		
		menu =x;
		setBorder(new EmptyBorder(100,900,1500,900));
		setBackground(new Color(8,178 ,227));
		JLabel label = new JLabel("IQ PUZZLER PRO");
		//label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 100));
		label.setForeground(Color.orange);
		label.setBounds(200, 500, 239, 31);
		add(label);

		JButton startButton = new JButton("Start Game");
		JButton howToPlayButton = new JButton("How To Play");
		JButton statisticsButton = new JButton("Statistics");
		JButton creditsButton = new JButton("Credits");
		JButton settingsButton = new JButton("Settings");
		JButton exitButton = new JButton("Exit");

		creditsButton.setOpaque(true);
		howToPlayButton.setOpaque(true);
		statisticsButton.setOpaque(true);
		settingsButton.setOpaque(true);
		startButton.setOpaque(true);
		creditsButton.setBackground(Color.RED);
		howToPlayButton.setBackground(Color.RED); 
		statisticsButton.setBackground(Color.RED); 
		settingsButton.setBackground(Color.RED);
		startButton.setBackground(Color.RED);
		creditsButton.setPreferredSize(new Dimension(300, 80));
		howToPlayButton.setPreferredSize(new Dimension(300, 80));
		statisticsButton.setPreferredSize(new Dimension(300, 80));
		settingsButton.setPreferredSize(new Dimension(300, 80));
		startButton.setPreferredSize(new Dimension(300, 80));
		
		startButton.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		howToPlayButton.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		statisticsButton.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		creditsButton.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		settingsButton.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

		startButton.addActionListener(new startListener());
		howToPlayButton.addActionListener(new howtListener());
		statisticsButton.addActionListener(new statListener());
		creditsButton.addActionListener(new creditsListener());
		settingsButton.addActionListener(new settingsListener());

		
		add(startButton);
		add(settingsButton);
		add(howToPlayButton);
		add(statisticsButton);
		add(creditsButton);
		
		
		exitButton.setBackground(new Color(59, 89, 182));
		exitButton.setForeground(Color.WHITE);
		exitButton.setFocusPainted(false);
		exitButton.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		exitButton.addActionListener(new exitListener());
		add(exitButton);



	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		ImageIcon img;
		img = new ImageIcon("background.jpg");
		img.paintIcon(null, g, 0, 0);
	}
	
	public class exitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit((0));
		}	

	}
	public class settingsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			SettingsPanel s = new SettingsPanel(menu);
			menu.show(s);

		}	

	}
	public class creditsListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			setVisible(false);
			CreditsPanel c = new CreditsPanel(menu);
			menu.show(c);
		}	

	}
	public class howtListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			HowToPlayPanel h = new HowToPlayPanel(menu);
			menu.show(h);
		}	

	}
	public class statListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			StatisticsPanel s = new StatisticsPanel(menu);
			menu.show(s);
		}	

	}

	public class startListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			levelPanel l = new levelPanel(menu);
			menu.show(l);
		}	

	}
}

