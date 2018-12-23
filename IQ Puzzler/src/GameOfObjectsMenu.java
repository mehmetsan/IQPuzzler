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
	FileManager fm = new FileManager();
	 File yourFile = new File("8-punk-8-bit-music.wav");
	    AudioInputStream stream;
	    AudioFormat format;
	    DataLine.Info info;
	  Clip clip;
	     
	    
	private MainPanel main;
	public GameOfObjectsMenu() throws LineUnavailableException, UnsupportedAudioFileException, IOException, InterruptedException {
		
		stream = AudioSystem.getAudioInputStream(yourFile);
	    format = stream.getFormat();
	    info = new DataLine.Info(Clip.class, format);
	    clip = (Clip) AudioSystem.getLine(info);
	    clip.open(stream);
	    
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
		musicBegin();
	}
      public void show(JPanel panel){
        	getContentPane().removeAll();
        	add(panel);
        }
       public void music() throws LineUnavailableException, IOException, InterruptedException
   {
  	 
   	    
   	 if(fm.readSettingsFile(0).equals("true"))
   	 {
   	    clip.start();
   	    clip.loop(Clip.LOOP_CONTINUOUSLY);
         Thread.sleep(1000); // looping as long as this thread is alive
   	    
   	}
   }
   	 public void musicBegin() throws LineUnavailableException, IOException, InterruptedException
     {
   		   clip.start();
     	   clip.loop(Clip.LOOP_CONTINUOUSLY);
           //Thread.sleep(10000); // looping as long as this thread is alive	 
   	
   }
   public void closeMusic()
   {
	   		 clip.stop();
   }
    

	public class exitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit((0));
		}	

	}
        
	public static void main(String[] args)  throws LineUnavailableException, UnsupportedAudioFileException, IOException, InterruptedException{
		new GameOfObjectsMenu();
	}
}
