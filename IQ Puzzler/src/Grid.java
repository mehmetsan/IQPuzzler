
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Grid  {

	private Box [][] boxes;
	private int locationX;
	private int locationY;
	private  int trueCount;
	private  Dimension dim = new Dimension(240, 140);
	private  boolean occupied[][];


	public Grid() {
		occupied = new boolean[5][11];
		locationX = 520;
		locationY = 480;
		boxes = new Box[5][11];
		for(int i= 0; i< 5; i++) {
			for(int j = 0; j< 11;j++) {
				boxes[i][j] = new Box(locationX , locationY);
				locationX += 41;
				occupied[i][j] = true;
			}
			locationX = 520;
			locationY += 41;
		}

	}

	public Box[] makeOccupied(int [] x , int [] y , int boxCount) {

		int return1 = 0;
		Box trueBoxes[] = new Box[boxCount];
		for(int i= 0; i< 5; i++) {
			for(int j = 0; j< 11;j++) {
				for(int s = 0; s< boxCount; s++) {
					if(boxes[i][j].contains(x[s], y[s])) {
						if(!occupied[i][j]){
							trueBoxes[return1] = boxes[i][j];
							return1++;
						}
					}
				}
			}
		}

		trueCount = return1;
		return trueBoxes;
	}


	public int makeEmpty(int [] x , int [] y , int boxCount , int moveCount) {
		int move = 0;
		for(int i= 0; i< 5; i++) 
			for(int j = 0; j< 11;j++) 
				for(int s = 0; s < boxCount; s++) 
					if(boxes[i][j].contains(x[s], y[s])) {
						move++;
						occupied[i][j] = false;
					}
		if(move > 0)
			
			return moveCount+1;
		
		return moveCount;
	}

	
	public boolean isFinished() {
		for(int i= 0; i< 5; i++) 
			for(int j = 0; j< 11;j++) 
				if(!occupied[i][j]) 
					return false;


		return true;
	}

	public void setLevel(int level) {
		if(level == 1) {
			for(int i= 3; i< 5; i++) 
				for(int j = 9; j< 11;j++)
					occupied[i][j] =false;
		}
		
		
		else if (level == 2){
			for(int i= 2; i< 5; i++) 
				for(int j = 8; j< 11;j++)
					occupied[i][j] =false;
		}
		
		else if (level == 3){
			for(int i= 1; i< 5; i++) 
				for(int j = 10; j > 10-i ;j--)
					occupied[i][j] =false;
		}
		
		else if (level == 4){
			for(int i= 0; i< 5; i++) 
				for(int j = 8; j< 11;j++)
					occupied[i][j] =false;
		}
		
		
		else if (level == 5){
			for(int i= 1; i< 5; i++) 
				for(int j = 7; j< 11;j++)
					occupied[i][j] =false;
			
			occupied[1][7] = true;
		}
		
		else if (level == 6){
			for(int i= 0; i< 5; i++) 
				for(int j = 7; j< 11;j++)
					occupied[i][j] =false;
			
			occupied[0][7] = true;
		}
		
		else if (level == 7){
			for(int i= 0; i< 5; i++) 
				for(int j = 8; j< 11;j++)
					occupied[i][j] =false;
			occupied[2][7] =false;
			occupied[3][6] =false;
			occupied[3][7] =false;
			occupied[4][6] =false;
			occupied[4][7] =false;
			
		}
				
		else if (level == 8){
			int counter = 8;
			for(int i= 0; i< 5; i++) {
				for(int j = counter; j< 11;j++)
					occupied[i][j] =false;
				counter--;
			}
			occupied[0][8] =true;			
		}
		
		else if (level == 9){

			for(int i= 0; i< 5; i++) {
				for(int j = 6; j< 11;j++)
					occupied[i][j] =false;
			}
			
			occupied[3][5] =false;	
			occupied[4][4] =false;
			occupied[4][5] =false;
		}
		
		else if (level == 10){

			for(int i= 0; i< 5; i++) {
				for(int j = 6; j< 11;j++)
					occupied[i][j] =false;
			}
			
			occupied[1][6] =true;	
			occupied[3][6] =true;
		}
		
		else if (level == 11){

			for(int i= 0; i< 5; i++) {
				for(int j = 6; j< 11;j++)
					occupied[i][j] =false;
			}
			
			occupied[0][6] =true;	
		}
		
		else if (level == 12){

			for(int i= 0; i< 5; i++) {
				for(int j = 6; j< 11;j++)
					occupied[i][j] =false;
			}
			
			occupied[3][6] =true;	
		}
		
		else if (level == 13){

			for(int i= 0; i< 5; i++) {
				for(int j = 5; j< 11;j++)
					occupied[i][j] =false;
			}
			
			occupied[0][5] =true;	
		}
		
		else if (level == 14){
			for(int i= 0; i< 5; i++) {
				for(int j = 5; j< 11;j++)
					occupied[i][j] =false;
			}
			occupied[0][5] = true;
			occupied[0][6] = true;
			occupied[4][4] =false;			
		}
		
		else if (level == 15){
			for(int i= 0; i< 5; i++) {
				for(int j = 4; j< 11;j++)
					occupied[i][j] =false;
			}
			occupied[0][4] = true;
			occupied[0][5] = true;
			occupied[1][4] = true;			
		}
		
		else if (level == 16){
			for(int i= 0; i< 5; i++) {
				for(int j = 4; j< 11;j++)
					occupied[i][j] =false;
			}
			occupied[2][4] = true;
			occupied[3][4] = true;
			occupied[3][5] = true;
			occupied[4][4] = true;			
		}
		
		else if (level == 17){
			for(int i= 0; i< 5; i++) {
				for(int j = 4; j< 11;j++)
					occupied[i][j] =false;
			}
			occupied[0][4] = true;
			occupied[1][4] = true;
			occupied[3][4] = true;			
		}
		
		else if (level == 18){
			for(int i= 0; i< 3; i++) {
				for(int j = 4; j< 11;j++)
					occupied[i][j] =false;
			}
			
			for(int i= 3; i< 5; i++) {
				for(int j = 7; j< 11;j++)
					occupied[i][j] =false;
			}
			
			occupied[3][5] = false;
			occupied[0][3] = false;		
		}
		
		else if (level == 19){
			for(int i= 0; i< 2; i++) {
				for(int j = 3; j< 11;j++)
					occupied[i][j] =false;
			}
			
			for(int i= 2; i< 5; i++) {
				for(int j = 5; j< 11;j++)
					occupied[i][j] =false;
			}
			occupied[1][2] = false;
			occupied[2][3] = false;
			occupied[2][4] = false;
			occupied[4][5] = true;		
		}
		
		else if (level == 20){
			for(int i= 0; i< 5; i++) {
				for(int j = 6; j< 11;j++)
					occupied[i][j] =false;
			}
			
			for(int i= 1; i< 4; i++) {
				for(int j = 3; j < 6;j++)
					occupied[i][j] =false;
			}
			
			occupied[2][2] = false;
			occupied[4][4] = false;
			occupied[4][5] = false;		
		}

	}

	public boolean[][] getOccupied() {
		// TODO Auto-generated method stub
		return occupied;
	}

	public Box[][] getBoxes() {
		// TODO Auto-generated method stub
		return boxes;
	}

	public void setOccupied(boolean[][] occupied2) {
		occupied = occupied2;
		
	}

	public int getTrueCount() {
		// TODO Auto-generated method stub
		return trueCount;
	}
	
}//
