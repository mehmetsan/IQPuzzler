import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class SettingsPanel extends JPanel {
	private GameOfObjectsMenu menu;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String currentColor;
	String currentAudio;
	FileManager fm = new FileManager();
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
		label.setForeground(Color.ORANGE);
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
		sounds.setBounds(100, 105, 200, 20);
		sounds.setSize(300, 90);
		sounds.setBackground(new Color(8,178 ,227));
		add(sounds);
		
		JLabel label2 = new JLabel("Sound: ");
		//label.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Tahoma", Font.BOLD, 25 ));
		label2.setBounds(20, 100, 100, 25);
		label2.setForeground(Color.ORANGE);
		label2.setBackground(new Color(8,178 ,227));
		add(label2);
		
	    JRadioButton button1 = new JRadioButton("OFF");
	    button1.setActionCommand("OFF");
	    button1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    button1.setForeground(Color.ORANGE);
	    button1.setBackground(new Color(8,178 ,227));
	   /* if(fm.readSettingsFile(0) == "false")
		    button1.setSelected(true);
	    else
	    	 button1.setSelected(false);
	    	 */
	    button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
		       
				currentColor = fm.readSettingsFile(1);
				fm.deleteSettings();
				fm.writeSettingsFile("false");
				fm.writeSettingsFile(currentColor);
				
					menu.closeMusic();
				
				}	
	    });
	    JRadioButton button2 = new JRadioButton("ON");
	    //button2.setMnemonic(KeyEvent.VK_C);
	    button2.setActionCommand("ON");
	    button2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    button2.setBackground(new Color(8,178 ,227));
	    button2.setSelected(true);
	    button2.setForeground(Color.ORANGE);
	    /*if(fm.readSettingsFile(0) == "true")
	    button2.setSelected(true);
	    else
	   	button2.setSelected(false);	*/
	    button2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
	       
			currentColor = fm.readSettingsFile(1);
			fm.deleteSettings();
			fm.writeSettingsFile("true");
			fm.writeSettingsFile(currentColor);
			try {
				menu.music();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}	
		
		});
	    ButtonGroup group = new ButtonGroup();
	    group.add(button1);
	    group.add(button2);
	    button1.setBounds(90, 200, 60, 25);
	    add(button1);
	    button2.setBounds(30, 200, 60, 25);
	    
	    JButton button3 = new JButton("Reset Statistics");
	    button3.setBounds(20, 300, 300, 30);
	    button3.setBackground(new Color(59, 89, 182));
	    button3.setForeground(Color.WHITE);
	    button3.setFocusPainted(false);
	    button3.setFont(new Font("Tahoma", Font.BOLD, 25));
	    button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			      JOptionPane opt = new JOptionPane(); 
			      opt.showMessageDialog(null, "Statistics are succesfully resetted");
			      add(opt);
				fm.deleteBombAll();
				fm.deleteCasualAll();
				fm.deleteLevelAll();
			}
			});
		
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
	    add(button3);
	    
	    
		
		
		
		
		
	}
	public class backListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	       
			setVisible(false);
			MainPanel m = new MainPanel(menu);
			menu.show(m);
	       
			}	
		
		}
}
