import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StatisticsPanel extends JPanel {
	private GameOfObjectsMenu menu;
	private FileManager fm;
	private String timeSpent;
	private String totalMove;
	private String totalPlay;
	private String timeSpent2;
	private String totalMove2;
	private String totalPlay2;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public StatisticsPanel(GameOfObjectsMenu x) {
		fm = new FileManager();
		setLayout(null);
		menu = x;
		setBackground(new Color(8,178 ,227));
		JLabel label = new JLabel("Statistics");
		//label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.red);
		label.setFont(new Font("Tahoma", Font.BOLD, 35));
		label.setBounds(20, 25, 240, 30);
		add(label);

		JButton back = new JButton("Back");
		//btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		back.setBounds(20, 500, 200, 60);
		back.setBackground(new Color(59, 89, 182));
		back.setForeground(Color.WHITE);
		back.setFocusPainted(false);
		back.setFont(new Font("Tahoma", Font.BOLD, 25));
		back.addActionListener(new backListener());
		add(back);


		timeSpent = fm.readCasualFile(0);
		totalMove = fm.readCasualFile(1);
		totalPlay = fm.readCasualFile(2);

		timeSpent2 = fm.readBombFile(0);
		totalMove2 = fm.readBombFile(1);
		totalPlay2 = fm.readBombFile(2);



		JLabel label1 = new JLabel("SinglePlayer-Casual");
		JLabel label2 = new JLabel("Total Time Spent                       " + timeSpent+	"                                                   " +  timeSpent2);
		JLabel label3 = new JLabel("Total Move Number                   " + totalMove+	"                                                   " +  totalMove2);
		JLabel label4 = new JLabel("Total Play Count                        " + totalPlay+	"                                                     " +  totalPlay2);
		JLabel label5 = new JLabel("SinglePlayer-TimeBomb");



		
		label1.setFont(new Font("Tahoma", Font.BOLD, 40));
		label1.setBounds(320, 50, 500, 300);
		label1.setForeground(Color.red);
		add(label1);
		label2.setFont(new Font("Tahoma", Font.BOLD, 30));
		label2.setBounds(20, 120, 2000, 300);
		label2.setForeground(Color.RED);
		add(label2);
		label3.setFont(new Font("Tahoma", Font.BOLD, 30));
		label3.setBounds(20, 220, 2000, 300);
		label3.setForeground(Color.RED);
		add(label3);
		label4.setFont(new Font("Tahoma", Font.BOLD, 30));
		label4.setBounds(20, 320, 2000, 300);
		label4.setForeground(Color.RED);
		add(label4);
		label5.setFont(new Font("Tahoma", Font.BOLD, 40));
		label5.setBounds(780, 50, 500, 300);
		label5.setForeground(Color.red);
		add(label5);




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