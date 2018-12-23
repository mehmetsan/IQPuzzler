import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class SettingsPanel extends JPanel {
	private GameOfObjectsMenu menu;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public SettingsPanel(GameOfObjectsMenu x) {
		setLayout(null);
		menu = x;
		setBackground(new Color(8,178 ,227));
		JLabel label = new JLabel("Settings");
		//label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 35));
		label.setBounds(20, 25, 240, 45);
		add(label);
		
		
		int min = 0;
		int max = 30;
		int init = 15;

		JSlider sounds = new JSlider(JSlider.HORIZONTAL,
		                                      min, max, init);
		//Turn on labels at major tick marks.
		sounds.setMajorTickSpacing(10);
		sounds.setMinorTickSpacing(1);
		sounds.setPaintTicks(true);
		sounds.setBounds(120, 105, 200, 20);
		sounds.setBackground(new Color(8,178 ,227));
		add(sounds);
		
		JLabel label2 = new JLabel("Sound: ");
		//label.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Tahoma", Font.BOLD, 17 ));
		label2.setBounds(20, 100, 100, 25);
		label2.setBackground(new Color(8,178 ,227));
		add(label2);
		
	    JRadioButton button1 = new JRadioButton("OFF");
	    button1.setActionCommand("OFF");
	    button1.setSelected(true);
	    button1.setFont(new Font("Tahoma", Font.PLAIN, 17));
	    button1.setBackground(new Color(8,178 ,227));
	    
	    JRadioButton button2 = new JRadioButton("ON");
	    //button2.setMnemonic(KeyEvent.VK_C);
	    button2.setActionCommand("ON");
	    button2.setFont(new Font("Tahoma", Font.PLAIN, 17));
	    button2.setBackground(new Color(8,178 ,227));
		
	    ButtonGroup group = new ButtonGroup();
	    group.add(button1);
	    group.add(button2);
	    button1.setBounds(120, 130, 60, 25);
	    add(button1);
	    button2.setBounds(180, 130, 60, 25);
	    
	    JButton back = new JButton("Back");
		//btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		back.setBounds(20, 500, 100, 30);
		back.setBackground(new Color(59, 89, 182));
		back.setForeground(Color.WHITE);
		back.setFocusPainted(false);
		back.setFont(new Font("Tahoma", Font.BOLD, 25));
		back.addActionListener(new backListener());
		add(back);
	    add(button2);
	    
	    
		JLabel label3 = new JLabel("Background: ");
		//label.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Tahoma", Font.BOLD, 17 ));
		label3.setBounds(20, 200, 120, 25);
		add(label3);
		
		
		String[] colors = new String[] {"Blue", "Red", "Yellow", "Green"};

		JComboBox<String> colorChange = new JComboBox<>(colors);
		colorChange.setFont(new Font("Tahoma", Font.PLAIN, 17 ));
		colorChange.setBounds(150, 205, 90, 20);
		add(colorChange);
		
		
		JLabel label4 = new JLabel("Time Limit: ");
		//label.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setFont(new Font("Tahoma", Font.BOLD, 17 ));
		label4.setBounds(20, 160, 100, 25);
		add(label4);
		
		
		String[] times = new String[] {"5 minutes", "10 minutes", "15 minutes", "20 minutes"};

		JComboBox<String> timeChange = new JComboBox<>(times);
		timeChange.setFont(new Font("Tahoma", Font.PLAIN, 17 ));
		timeChange.setBounds(150, 165, 90, 20);
		add(timeChange);
	}
	public class backListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	       
			setVisible(false);
			MainPanel m = new MainPanel(menu);
			menu.show(m);
	       
			}	
		
		}
}