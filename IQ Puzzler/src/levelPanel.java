import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;


import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

public class levelPanel extends JPanel {
	private JRadioButton single;
	private JRadioButton multi;
	private JRadioButton timeBomb;
	private JRadioButton casual;
	private FileManager fm;
	private int mode;
	private int playable[];

	private static final long serialVersionUID = 1L;
	GameOfObjectsMenu menu;

	public levelPanel(GameOfObjectsMenu a) {
		setBackground(new Color(8,178 ,227));
		mode = 0;
		menu = a;
		playable = new int[20];
		setLayout(null);
		fm = new FileManager();
		
		for(int i= 0; i < 20; i++) {
			playable[i] = Integer.parseInt(fm.readLevelFile(i));
		}

		JLabel label = new JLabel("Select Level");
		//label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
		label.setForeground(Color.red);
		label.setBounds(640, 25, 600, 45);
		add(label);

		single = new JRadioButton("SinglePlayer");
		single.addActionListener(new modeListener());
		single.setName("single");
		single.setBounds(600,150 , 200 , 60);
		single.setSelected(true);
		single.setOpaque(false);
		single.setContentAreaFilled(false);
		single.setBorderPainted(false);
		single.setForeground(Color.red);
		single.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		add(single);

		multi = new JRadioButton("MultiPlayer");
		multi.addActionListener(new modeListener());
		multi.setName("multi");
		multi.setBounds(800, 150 , 200 , 60);
		multi.setOpaque(false);
		multi.setContentAreaFilled(false);
		multi.setBorderPainted(false);
		multi.setForeground(Color.red);
		multi.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		add(multi);
		
		casual = new JRadioButton("Casual");
		casual.addActionListener(new modeListener());
		casual.setName("casual");
		casual.setBounds(600, 250 , 100 , 30);
		casual.setSelected(true);
		casual.setOpaque(false);
		casual.setContentAreaFilled(false);
		casual.setBorderPainted(false);
		casual.setForeground(Color.red);
		casual.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		add(casual);
		

		timeBomb = new JRadioButton("TimeBomb");
		timeBomb.addActionListener(new modeListener());
		timeBomb.setName("timeBomb");
		timeBomb.setBounds(800, 250 , 150 , 30);
		timeBomb.setOpaque(false);
		timeBomb.setContentAreaFilled(false);
		timeBomb.setBorderPainted(false);
		timeBomb.setForeground(Color.red);
		timeBomb.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		add(timeBomb);
		


		JButton one = new JButton("1");
		one.addActionListener(new oneListener());
		one.setName("1");
		one.setBounds(400, 300, 200, 60);
		add(one);

		JButton two = new JButton("2");
		two.addActionListener(new oneListener());
		two.setName("2");
		two.setBounds(600, 300, 200, 60);
		if(playable[1] == 0)
			two.setEnabled(false);
		add(two);

		JButton three = new JButton("3");
		three.addActionListener(new oneListener());
		three.setName("3");
		three.setBounds(800, 300, 200, 60);
		if(playable[2] == 0)
			three.setEnabled(false);
		add(three);

		JButton four = new JButton("4");
		four.addActionListener(new oneListener());
		four.setName("4");
		four.setBounds(1000, 300, 200, 60);
		if(playable[3] == 0)
			four.setEnabled(false);
		add(four);

		JButton five = new JButton("5");
		five.addActionListener(new oneListener());
		five.setName("5");
		five.setBounds(400, 360, 200, 60);
		if(playable[4] == 0)
			five.setEnabled(false);
		add(five);

		JButton six = new JButton("6");
		six.addActionListener(new oneListener());
		six.setName("6");
		six.setBounds(600, 360, 200, 60);
		if(playable[5] == 0)
			six.setEnabled(false);
		add(six);

		JButton seven = new JButton("7");
		seven.addActionListener(new oneListener());
		seven.setName("7");
		seven.setBounds(800, 360, 200, 60);
		if(playable[6] == 0)
			seven.setEnabled(false);
		add(seven);

		JButton eight = new JButton("8");
		eight.addActionListener(new oneListener());
		eight.setName("8");
		eight.setBounds(1000, 360, 200, 60);
		if(playable[7] == 0)
			eight.setEnabled(false);
		add(eight);

		JButton nine = new JButton("9");
		nine.addActionListener(new oneListener());
		nine.setName("9");
		nine.setBounds(400, 420, 200, 60);
		if(playable[8] == 0)
			nine.setEnabled(false);
		add(nine);

		JButton ten = new JButton("10");
		ten.addActionListener(new oneListener());
		ten.setName("10");
		ten.setBounds(600, 420, 200, 60);
		if(playable[9] == 0)
			ten.setEnabled(false);
		add(ten);

		JButton eleven = new JButton("11");
		eleven.addActionListener(new oneListener());
		eleven.setName("11");
		eleven.setBounds(800, 420, 200, 60);
		if(playable[10] == 0)
			eleven.setEnabled(false);
		add(eleven);

		JButton twelve = new JButton("12");
		twelve.addActionListener(new oneListener());
		twelve.setName("12");
		twelve.setBounds(1000, 420, 200, 60);
		if(playable[11] == 0)
			twelve.setEnabled(false);
		add(twelve);

		JButton thirteen = new JButton("13");
		thirteen.addActionListener(new oneListener());
		thirteen.setName("13");
		thirteen.setBounds(400, 480, 200, 60);
		if(playable[12] == 0)
			thirteen.setEnabled(false);
		add(thirteen);

		JButton fourteen = new JButton("14");
		fourteen.addActionListener(new oneListener());
		fourteen.setName("14");
		fourteen.setBounds(600, 480, 200, 60);
		if(playable[13] == 0)
			fourteen.setEnabled(false);
		add(fourteen);

		JButton fifteen = new JButton("15");
		fifteen.addActionListener(new oneListener());
		fifteen.setName("15");
		fifteen.setBounds(800, 480, 200, 60);
		if(playable[14] == 0)
			fifteen.setEnabled(false);
		add(fifteen);

		JButton sixteen = new JButton("16");
		sixteen.addActionListener(new oneListener());
		sixteen.setName("16");
		sixteen.setBounds(1000, 480, 200, 60);
		if(playable[15] == 0)
			sixteen.setEnabled(false);
		add(sixteen);

		JButton seventeen = new JButton("17");
		seventeen.addActionListener(new oneListener());
		seventeen.setName("17");
		seventeen.setBounds(400, 540, 200, 60);
		if(playable[16] == 0)
			seventeen.setEnabled(false);
		add(seventeen);

		JButton eighteen = new JButton("18");
		eighteen.addActionListener(new oneListener());
		eighteen.setName("18");
		eighteen.setBounds(600, 540, 200, 60);
		if(playable[17] == 0)
			eighteen.setEnabled(false);
		add(eighteen);

		JButton nineteen = new JButton("19");
		nineteen.addActionListener(new oneListener());
		nineteen.setName("19");
		nineteen.setBounds(800, 540, 200, 60);
		if(playable[18] == 0)
			nineteen.setEnabled(false);
		add(nineteen);

		JButton twenty = new JButton("20");
		twenty.addActionListener(new oneListener());
		twenty.setName("20");
		twenty.setBounds(1000, 540, 200, 60);
		if(playable[19] == 0)
			twenty.setEnabled(false);
		add(twenty);


		JButton back = new JButton("Back");
		//btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		back.setBounds(700, 700, 200, 60);
		back.setBackground(new Color(59, 89, 182));
		back.setForeground(Color.WHITE);
		back.setFocusPainted(false);
		back.setFont(new Font("Tahoma", Font.BOLD, 40));
		back.addActionListener(new backListener());
		add(back);
		
		

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
	public class oneListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);



			String s = ((JComponent) e.getSource()).getName();
			int level = Integer.parseInt(s);
			GameManager c = new GameManager(menu,level,mode);
			menu.show(c);

		}	
	}

	public class modeListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			String s = ((JComponent) e.getSource()).getName();
			if(s == "multi") {
				mode = 1;
				single.setSelected(false);
				casual.setVisible(false);
				timeBomb.setVisible(false);

			}

			else if(s == "single") {
				mode = 0;
				multi.setSelected(false);
				casual.setVisible(true);
				timeBomb.setVisible(true);
				
				
				
			}

			else if(s == "timeBomb") {
				casual.setSelected(false);
				mode = 3;
			}

			else if(s == "casual") {
				timeBomb.setSelected(false);
				mode = 0;
			}

		}	
	}


}
