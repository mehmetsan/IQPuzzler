/*
* IQ Puzzler Term Project
* CS319  Section:2
* This project was developed for Object Oriented Programming Course Term Project by
* -Arda Türkoğlu
* -Engin Deniz Kopan
* -Zafer Çınar
* -Mehmet Selim Özcan
* -Mehmet Sanisoğlu
*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



/*
 * 
 * This is Box class that extends Rectangle
 * 
 * 
 */
public class Box extends Rectangle {
	public Box(int x , int y) {
		setBounds(0, 0, 40, 40);
		setLocation(x , y);	
	}
}
