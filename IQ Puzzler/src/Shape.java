


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


public class Shape {

	private Box[] boxes;
	private int locationX;
	private int locationY;
	
	public Shape() {
		boxes = new Box[5];
		locationX = 50;
		locationY = 10;	
		currentLocation = 50;
		check = false;
	}
	
	
	public Box[] getBoxes() {
		return boxes;
	}

	public void setBoxes(Box[] boxes) {
		this.boxes = boxes;
	}

	public int getLocationX() {
		return locationX;
	}



	public int getLocationY() {
		return locationY;
	}


	public int getCurrentLocation() {
		return currentLocation;
	}


	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	private int currentLocation;
	private boolean check;

	
	public void setX(int x) {
		locationX = x;
	}
	
	public void setY(int y) {
		locationY = y;
	}
	
	public void setCurrent(int x) {
		currentLocation = x;
	}



}



