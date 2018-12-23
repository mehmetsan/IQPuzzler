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
public class ShapeCollection {

	private Shape shapes [];
	private int arr [][][];
	private int count [];
	private int locations[][] ;
	private int levelShapes[];

	ShapeCollection(){
		arr = new int[12][4][4];
		locations = new int[12][10];

		levelShapes = new int[12];
		shapes = new Shape[12];
		for(int i = 0; i<12; i++)
			shapes[i] = new Shape();

		count = new int[12];

		//lacivert
		arr[0][0][1]= 1;
		arr[0][0][2]= 1;
		arr[0][1][1]= 1;
		arr[0][2][1]= 1;
		arr[0][3][1]= 1;

		//koyu yeþil
		arr[1][1][0]= 1;
		arr[1][1][1]= 1;
		arr[1][1][2]= 1;
		arr[1][2][2]= 1;
		arr[1][2][3]= 1;

		//kýrmýzý
		arr[2][1][0]= 1;
		arr[2][1][1]= 1;
		arr[2][1][2]= 1;
		arr[2][2][1]= 1;
		arr[2][2][2]= 1;

		//sarý
		arr[3][0][1]= 1;
		arr[3][0][2]= 1;
		arr[3][1][1]= 1;
		arr[3][2][1]= 1;
		arr[3][2][2]= 1;

		//gri
		arr[4][0][2]= 1;
		arr[4][1][1]= 1;
		arr[4][1][2]= 1;
		arr[4][1][3]= 1;
		arr[4][2][2]= 1;

		//turuncu
		arr[5][1][1]= 1;
		arr[5][1][2]= 1;
		arr[5][2][2]= 1;
		arr[5][3][2]= 1;


		//krem
		arr[6][1][2]= 1;
		arr[6][2][0]= 1;
		arr[6][2][1]= 1;
		arr[6][2][2]= 1;
		arr[6][2][3]= 1;

		//mor
		arr[7][2][0]= 1;
		arr[7][2][1]= 1;
		arr[7][2][2]= 1;
		arr[7][2][3]= 1;

		//pembe
		arr[8][0][0]= 1;
		arr[8][0][1]= 1;
		arr[8][1][1]= 1;
		arr[8][1][2]= 1;
		arr[8][2][2]= 1;

		//beyaz
		arr[9][1][1]= 1;
		arr[9][2][1]= 1;
		arr[9][2][2]= 1;


		//açýk yeþil
		arr[10][1][1]= 1;
		arr[10][1][2]= 1;
		arr[10][2][1]= 1;
		arr[10][2][2]= 1;

		//açýk mavi
		arr[11][0][0]= 1;
		arr[11][0][1]= 1;
		arr[11][0][2]= 1;
		arr[11][1][0]= 1;
		arr[11][2][0]= 1;


		/*for(int i = 0; i<12;i++)
			shapes[i] = createShape(i,arr);*/

	}

	public int[] getLevelShapes() {
		levelShapes[0] = 10;
		return levelShapes;
	}

	public Shape createShape(int s, int [][][]arr) {
		int k = 0;
		int locCount = 0;
		for(int i=0; i<4; i++) {
			for(int j = 0; j<4;j++) {
				if(arr[s][i][j] == 1) {
					shapes[s].getBoxes()[k] = new Box(shapes[s].getLocationX() , shapes[s].getLocationY());
					locations[s][locCount] = (shapes[s].getLocationX());
					locations[s][locCount+1] =shapes[s].getLocationY();
					k++;
					locCount += 2;
				}
				shapes[s].setX(shapes[s].getLocationX() + 41);
			}
			shapes[s].setX(shapes[s].getCurrentLocation());
			shapes[s].setY(shapes[s].getLocationY() + 41);	

		}	
		if(s != 11) {
			shapes[s+1].setCurrent( shapes[s].getCurrentLocation() + 250);
			shapes[s+1].setX(shapes[s].getCurrentLocation()+250);

			if(s == 5) {
				shapes[s+1].setX(50);
				shapes[s+1].setCurrent( 50);
			}

			if(s >= 5)
				shapes[s+1].setY(250);


		}
		count[s] = k;
		return shapes[s];


	}

	public int getCount(int x) {
		return count[x];
	}

	public void symmetry( int dummy) {
		int arr2[][][] = new int[12][4][4];
		int count = getCount(dummy);
		int count2 = 0;

		for(int i = 0 ; i < 4; i++ ) {
			for(int j = 0; j < 4; j++) {
				if(count2 < count && arr[dummy][i][j] == 1) {
					arr2[dummy][i][3-j] = 1;
					count2++;
				}
			}
		}

		if(dummy <= 5)
			shapes[dummy].setY(10);

		else
			shapes[dummy].setY(250);
		for(int i =0; i< 4; i++)
			for(int j = 0; j< 4;j++)
				arr[dummy][i][j] = arr2[dummy][i][j];

		createShape(dummy, arr);

	}

	public void rotate( int dummy) {
		int arr2[][][] = new int[12][4][4];
		int count = getCount(dummy);
		int count2 = 0;

		for(int i = 0 ; i < 4; i++ ) {
			for(int j = 0; j < 4; j++) {
				if(count2 < count && arr[dummy][i][j] == 1) {
					arr2[dummy][j][3-i] = 1;
					count2++;
				}
			}
		}


		if(dummy <= 5)
			shapes[dummy].setY(10);

		else
			shapes[dummy].setY(250);
		for(int i =0; i< 4; i++)
			for(int j = 0; j< 4;j++)
				arr[dummy][i][j] = arr2[dummy][i][j];

		createShape(dummy, arr);

	}

	public void setLevel(int level) {
		if(level == 1) {
			arr[0] = arr[10];
			createShape(0 , arr);
		}

		else if(level == 2) {
			arr[0] = arr[10];
			arr[1] = arr[11];
			createShape(0 , arr);
			createShape(1 , arr);
		}

		else if(level == 3) {
			arr[1] = arr[8];
			for(int i = 0; i< 2; i++)
				createShape(i , arr);
		}

		else if(level == 4) {
			arr[1] = arr[11];
			for(int i = 0; i< 3; i++)
				createShape(i , arr);
		}

		else if(level == 5) {
			arr[0] = arr[3];

			for(int i = 0; i< 3; i++)
				createShape(i , arr);
		}


		else if(level == 6) {
			arr[2] = arr[10];
			arr[3] = arr[11];

			for(int i = 0; i< 4; i++)
				createShape(i , arr);
		}

		else if(level == 7) {
			arr[1] = arr[8];
			arr[2] = arr[11];
			for(int i = 0; i< 4; i++)
				createShape(i , arr);
		}

		else if(level == 8) {
			arr[1] = arr[8];
			arr[4] = arr[7];
			for(int i = 0; i< 5; i++)
				createShape(i , arr);

		}

		else if(level == 9) {
			arr[0] = arr[7];
			arr[1] = arr[8];
			for(int i = 0; i< 6; i++)
				createShape(i , arr);

		}

		else if(level == 10) {
			arr[0] = arr[7];
			arr[1] = arr[8];
			arr[2] = arr[6];
			arr[4] = arr[5];
			for(int i = 0; i< 5; i++)
				createShape(i , arr);

		}

		else if(level == 11) {
			arr[1] = arr[11];
			arr[3] = arr[5];

			for(int i = 0; i< 5; i++)
				createShape(i , arr);

		}

		else if(level == 12) {
			arr[1] = arr[11];
			arr[4] = arr[7];

			for(int i = 0; i< 5; i++)
				createShape(i , arr);

		}

		else if(level == 13) {
			arr[1] = arr[11];
			arr[3] = arr[8];
			arr[5] = arr[7];

			for(int i = 0; i< 6; i++)
				createShape(i , arr);

		}

		else if(level == 14) {
			arr[0] = arr[11];
			arr[2] = arr[10];
			arr[3] = arr[8];
			arr[5] = arr[6];
			for(int i = 0; i< 6; i++)
				createShape(i , arr);

		}

		else if(level == 15) {
			arr[0] = arr[10];
			arr[6] = arr[7];

			for(int i = 0; i< 7; i++)
				createShape(i , arr);

		}
		
		else if(level == 16) {
			arr[0] = arr[10];
			arr[3] = arr[9];
			arr[4] = arr[8];

			for(int i = 0; i< 7; i++)
				createShape(i , arr);

		}
		
		else if(level == 17) {
			arr[2] = arr[9];
			arr[5] = arr[8];
			arr[6] = arr[7];

			for(int i = 0; i< 7; i++)
				createShape(i , arr);

		}
		
		else if(level == 18) {
			arr[0] = arr[9];
			arr[1] = arr[8];
			arr[3] = arr[7];

			for(int i = 0; i< 7; i++)
				createShape(i , arr);

		}
		
		else if(level == 19) {
			arr[1] = arr[11];
			arr[2] = arr[9];
			arr[6] = arr[8];

			for(int i = 0; i< 8; i++)
				createShape(i , arr);

		}
		
		else if(level == 20) {
			arr[0] = arr[10];
			arr[5] = arr[9];
			arr[7] = arr[8];

			for(int i = 0; i< 8; i++)
				createShape(i , arr);

		}


	}

	public Shape[] getShapes() {
		return shapes;
	}
	
	public int[][] getLocations(){
		return locations;
	}

}



