



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import javafx.scene.input.MouseButton;



public class GameManager extends JPanel {

	GameOfObjectsMenu menu;
	private ShapeCollection col = new ShapeCollection();
	private Shape[] shapes = new Shape[12];
	private Grid grid = new Grid();
	private int [] preX = new int[5]; 
	private int [] preY = new int[5];
	private boolean finish = false;
	private boolean pressOut = false;
	private boolean showSol = false;
	private int dummy=100;
	private int locations[][];
	private Box trueBoxes[];
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JLabel timeLabel;
	private JLabel time0Label;
	private JLabel time2Label;
	private JLabel time3Label;
	private JLabel legend;
	private JLabel solution; 
	private int moveCount[];
	private int playable[];
	private JButton back;
	private JButton sol;
	private JButton finTour;
	private int level;
	private int mode;
	private Color color[];
	private boolean player1;
	private boolean gameOn;
	private  boolean occupied[][];
	private Box [][] boxes;
	private int turn;
	private Timer time;
	private Timer time0;
	private Timer time2;
	private Timer time3;
	private FileManager fm;
	private String totalTime;
	private String totalMove;
	private String totalPlay;
	private String totalTime2;
	private String totalMove2;
	private String totalPlay2;


	public GameManager(GameOfObjectsMenu x, int lvl , int mode) {
		gameOn = true;
		fm = new FileManager();
		playable = new int[20];
		locations = col.getLocations();
		occupied = grid.getOccupied();
		boxes = grid.getBoxes();
		moveCount = new int[21];
		ImageIcon img = new ImageIcon("solutions/"+lvl+ ".png");
		
		solution = new JLabel("sad");
		solution.setIcon(img);
		solution.setBounds(1000, 400, 200, 30);
		solution.setVisible(showSol);
		this.add(solution);

		for(int i= 0; i < 20; i++) {
			playable[i] = Integer.parseInt(fm.readLevelFile(i));
		}


		level = lvl;
		menu = x;
		this.mode = mode;
		//setBackground(Color.black);
		col.setLevel(level);
		grid.setLevel(level);
		shapes = col.getShapes();
		player1 = true;



		if(mode == 0) {
			totalTime = fm.readCasualFile(0);
			totalMove = fm.readCasualFile(1);
			totalPlay = fm.readCasualFile(2);
		}

		if(mode == 3) {
			totalTime2 = fm.readBombFile(0);
			totalMove2 = fm.readBombFile(1);
			totalPlay2 = fm.readBombFile(2);
		}



		legend = new JLabel("<html>Left-Click: Drag/ Put Shape Back <br>Right-Click  :Rotate Shape<br>Middle-Click :Take Symmetry of Shape");
		if(mode == 1) {
			legend = new JLabel("<html>Left-Click: Drag/ Put Shape Back <br>Right-Click  :Rotate Shape<br>Middle-Click :Take Symmetry of Shape<br>Each Player Has 2 Moves<br>Taking Out Shape   :-4 Time Penalty");
		}
		legend.setForeground(Color.white);
		legend.setFont(new Font("Serif", Font.BOLD, 23));
		legend.setBounds(10, 690, 10000, 120);
		this.add(legend);

		addMouseMotionListener(new MyMouseAdapter());
		addMouseListener(new MyMouseAdapter());



		back = new JButton("Back");
		back.setBackground(new Color(59, 89, 182));
		back.setForeground(Color.WHITE);
		back.setFocusPainted(false);
		back.setFont(new Font("Tahoma", Font.BOLD, 25));
		back.addActionListener(new backListener());
		add(back);
		
		sol = new JButton("Solution");
		sol.setBackground(new Color(59, 89, 182));
		sol.setForeground(Color.WHITE);
		sol.setFocusPainted(false);
		sol.setFont(new Font("Tahoma", Font.BOLD, 25));
		sol.addActionListener(new solListener());
		add(sol);



		label = new JLabel("Move Count = " + moveCount[level]);
		label.setForeground(Color.white);
		label.setFont(new Font("Serif", Font.BOLD, 25));
		label.setBounds(10, 700, 200, 30);
		this.add(label);

		if(mode == 0) {
			time0 = new Timer(1000 , new time0Listener());
			time0.start();

			timeLabel = new JLabel("TIME = ");
			timeLabel.setForeground(Color.white);
			timeLabel.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
			timeLabel.setBounds(1300, 650, 120, 120);
			this.add(timeLabel);

			time0Label = new JLabel("0");
			time0Label.setForeground(Color.white);
			time0Label.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
			time0Label.setBounds(1400, 650, 120, 120);
			this.add(time0Label);
		}

		if(mode == 1) {
			time = new Timer(1000 , new timeListener());

			time2 = new Timer(1000 , new time2Listener());

			label2 = new JLabel("Player 1");
			label2.setForeground(Color.orange);
			label2.setFont(new Font("Serif", Font.BOLD, 35));
			label2.setBounds(520, 400, 10000, 30);
			this.add(label2);

			label3 = new JLabel("Player 2");
			label3.setForeground(Color.white);
			label3.setFont(new Font("Serif", Font.BOLD, 35));
			label3.setBounds(820, 400, 10000, 30);
			this.add(label3);

			finTour = new JButton("Finish Tour");
			finTour.setBackground(new Color(59, 89, 182));
			finTour.setForeground(Color.WHITE);
			finTour.setFocusPainted(false);
			finTour.setFont(new Font("Tahoma", Font.BOLD, 25));
			finTour.addActionListener(new finListener());
			add(finTour);

			timeLabel = new JLabel(String.valueOf(7*level));
			timeLabel.setForeground(Color.white);
			timeLabel.setFont(new Font("Serif", Font.ROMAN_BASELINE, 35));
			timeLabel.setBounds(420, 400, 10000, 30);
			this.add(timeLabel);

			time2Label = new JLabel(String.valueOf(7*level));
			time2Label.setForeground(Color.white);
			time2Label.setFont(new Font("Serif", Font.ROMAN_BASELINE, 35));
			time2Label.setBounds(940, 400, 10000, 30);
			this.add(time2Label);

		}


		if(mode == 3) {

			time3 = new Timer(1000 , new time3Listener());
			time3.start();

			time3Label = new JLabel(String.valueOf(7*level));
			time3Label.setForeground(Color.white);
			time3Label.setFont(new Font("Serif", Font.BOLD, 30));
			time3Label.setBounds(1400, 650, 120, 120);
			this.add(time3Label);

		}

		color = new Color[12];
		color[0] = Color.blue;
		color[1] = Color.orange;
		color[2] = Color.cyan;
		color[3] = new Color(225,55,00);
		color[4] = Color.green;
		color[5] = new Color(53,88,52);
		color[6] = new Color(112,78,46);
		color[7] = new Color(60,27,67);
		color[8] = Color.magenta;
		color[9] = Color.pink;
		color[10] = new Color(51,124,160);
		color[11] = Color.orange;
		
	
	}

	@Override
	public void paintComponent(Graphics g) {
		ImageIcon img2;
		super.paintComponent(g);
		img2 = new ImageIcon("background.jpg");
		img2.paintIcon(null, g, 0, 0);
		
		legend.setBounds(10, 690, 10000, 200);
		
		label.setText("Move Count = " + moveCount[level]);
		label.setBounds(10, 650, 10000, 30);
		back.setBounds(20, 500, 100, 30);
		sol.setBounds(650, 750, 200, 30);
		solution.setBounds(510, 460, 600, 300);
		solution.setVisible(showSol);

		if(mode == 0) {
			time0Label.setBounds(1400, 650, 120, 120);
			timeLabel.setBounds(1300, 650, 120, 120);
		}

		if(mode == 1) {
			label2.setBounds(520, 400, 10000, 40);
			label3.setBounds(820, 400, 10000, 40);
			timeLabel.setBounds(660, 405, 10000, 30);
			time2Label.setBounds(960, 405, 10000, 30);
			finTour.setBounds(1200, 500, 200, 30);

			if(turn %4 == 0 || turn % 4 == 1)
				player1 = true;

			else
				player1 = false;

			if(player1 && gameOn) {
				time.start();
				time2.stop();
				label2.setForeground(color[1]);
				label3.setForeground(Color.white);
				timeLabel.setForeground(color[1]);
				time2Label.setForeground(Color.white);
			}

			else if(gameOn) {
				time2.start();
				time.stop();
				label3.setForeground(color[1]);
				label2.setForeground(Color.white);
				time2Label.setForeground(color[1]);
				timeLabel.setForeground(Color.white);
			}
		}

		if(mode == 3) {
			time3Label.setBounds(1400, 650, 120, 120);

		}

		Graphics2D g2d = (Graphics2D) g;




		Graphics2D g2d1 = (Graphics2D) g;
		for(int s = 0; s<5; s++) {
			for(int i = 0; i< 11; i++) {
				if(occupied[s][i]) {
					g2d1.setColor(Color.red);
				}
				else
					g2d1.setColor(Color.white);

				g2d1.fill(boxes[s][i]);
			}
		}

		for(int s = 0; s<12; s++) {
			for(int i = 0; i< col.getCount(s); i++) {
				g2d.setColor(color[s]);
				g2d.fill(shapes[s].getBoxes()[i]);	

			}
		}

	}

	public void changeTimer(int playerNo, int amount) {
		if(mode == 1) {
			if(playerNo == 0) {
				String x = timeLabel.getText();
				int val = Integer.parseInt(x);
				val -= amount; 
				timeLabel.setText(val + "");
			}
			else {
				String x = time2Label.getText();
				int val = Integer.parseInt(x);
				val -= amount; 
				time2Label.setText(val + "");
			}
		}
	}

	public class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			boolean bool = false;

			for(int s=0; s<12;s++) {
				for(int i = 0; i< col.getCount(s); i++) {
					preX[i] = shapes[s].getBoxes()[i].x - e.getX();
					preY[i]= shapes[s].getBoxes()[i].y - e.getY();

					if (shapes[s].getBoxes()[i].contains(e.getX(), e.getY())) {
						dummy = s;
					} 

				}
				if(dummy == s) {
					s = 12;
					pressOut = false;
				}
			}


			if(dummy < 12) {
				bool = placePiece(shapes[dummy]);

				if(dummy < 12 && grid.getTrueCount() == 0) {
					int boxCount = col.getCount(dummy);
					int  xs[] = new int[boxCount];
					int  ys[] = new int[boxCount];
					for(int i = 0; i <boxCount; i++)
					{
						xs[i] = shapes[dummy].getBoxes()[i].x;
						ys[i] = shapes[dummy].getBoxes()[i].y;

					}

					int copy = moveCount[level];
					moveCount[level] = grid.makeEmpty(xs , ys , boxCount, moveCount[level]);


					if(copy!=moveCount[level]) {

						if(player1) {
							changeTimer(0 , 4);
						}

						else 
							changeTimer(1, 4);
						turn ++;
					}

					else
						grid.makeEmpty(xs , ys , boxCount, 0);



					int locCount = 0;
					for(int i = 0; i< col.getCount(dummy); i++) {
						preX[i] = locations[dummy][locCount] - e.getX();
						preY[i] = locations[dummy][locCount+1] - e.getY();
						locCount += 2;
					}
				}
				if(dummy < 12 && e.getButton() == MouseEvent.BUTTON3) 
					col.rotate(dummy);

				if(dummy < 12 && e.getButton() == MouseEvent.BUTTON2)
					col.symmetry(dummy);
			}

			updateLocation(e);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if(!pressOut)
				updateLocation(e);

		}

		@Override
		public void mouseReleased(MouseEvent e) {


			if(dummy< 12 && !placePiece(shapes[dummy])){

				int locCount = 0;
				for(int i = 0; i< col.getCount(dummy); i++) {
					preX[i] = locations[dummy][locCount] - e.getX();
					preY[i] = locations[dummy][locCount+1] - e.getY();
					locCount += 2;
				}

			}


			else if(dummy < 12 ){
				moveCount[level] = moveCount[level] + 1;
				turn++;

				int boxCount = col.getCount(dummy);
				for(int i = 0; i< col.getCount(dummy); i++) {
					preX[i] = trueBoxes[i].x - e.getX();
					preY[i] = trueBoxes[i].y - e.getY();
				}

				for(int i= 0; i< 5; i++) {
					for(int j = 0; j< 11;j++) {
						for(int s = 0; s< boxCount; s++) {
							if(trueBoxes[s].x == boxes[i][j].x && trueBoxes[s].y == boxes[i][j].y) {
								occupied[i][j] = true;
							}
						}
					}
				}

				grid.setOccupied(occupied);
			}



			updateLocation(e);
			dummy = 100;
		}

		public void updateLocation(MouseEvent e) {
			if(dummy < 12) {
				for(int i = 0; i< col.getCount(dummy); i++) {
					shapes[dummy].getBoxes()[i].setLocation(preX[i] + e.getX(), preY[i] + e.getY());
					//checkRect();
				}

				repaint();
			}

			int selectedValue = 0;
			if(grid.isFinished()) {
				
				gameOn = false;
				if(mode == 0)
					time0.stop();
				
				if(mode == 3)
					time3.stop();
				
				if(mode == 1) {
					time2.stop();
					time.stop();
				}

				fm.deleteLevelAll();

				if(level != 20)
					playable[level] = 1;

				for(int i = 0; i< 20; i++) {
					fm.writeLevelFile(String.valueOf(playable[i]));
				}

				Object[] options = {"Previous Level",
						"Level Select",
				"Next Level"};

				if(mode == 0 || mode == 3) {
					if(mode == 0) {
						time0.stop();

						int totTime = Integer.parseInt(totalTime);
						totTime = totTime + Integer.parseInt(time0Label.getText());
						totalTime = String.valueOf(totTime);

						int totMove = Integer.parseInt(totalMove);
						totMove = totMove + moveCount[level];
						totalMove = String.valueOf(totMove);

						int totPlay = Integer.parseInt(totalPlay);	
						totPlay++;
						totalPlay = String.valueOf(totPlay);


						fm.deleteCasualAll();


						fm.writeCasualFile(totalTime);
						fm.writeCasualFile(totalMove);
						fm.writeCasualFile(totalPlay);

					}

					else {
						time3.stop();

						int totTime = Integer.parseInt(totalTime2);
						totTime = totTime + (7*level - Integer.parseInt(time3Label.getText()));
						totalTime2 = String.valueOf(totTime);

						int totMove = Integer.parseInt(totalMove2);
						totMove = totMove + moveCount[level];
						totalMove2 = String.valueOf(totMove);

						int totPlay = Integer.parseInt(totalPlay2);	
						totPlay++;
						totalPlay2 = String.valueOf(totPlay);


						fm.deleteBombAll();


						fm.writeBombFile(totalTime2);
						fm.writeBombFile(totalMove2);
						fm.writeBombFile(totalPlay2);
					}

					selectedValue = JOptionPane.showOptionDialog(null,
							"YOU WON!! CONGRATS!!",
							"LEVEL COMPLETED",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							options,
							options[2]);
				}

				else if(player1){
					selectedValue = JOptionPane.showOptionDialog(null,
							"PLAYER 1 HAS WON",
							"PLAYER 1 HAS WON",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							options,
							options[2]);
				}

				else {
					selectedValue = JOptionPane.showOptionDialog(null,
							"PLAYER 2 HAS WON",
							"PLAYER 2 HAS WON",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							options,
							options[2]);//s
				}


				if(selectedValue == 0 ) {
					setVisible(false);
					GameManager d = new GameManager(menu, level-1 , mode );
					menu.show(d);
				}
				if(selectedValue == 1 ) {
					setVisible(false);
					levelPanel d = new levelPanel(menu);
					menu.show(d);

				}
				if(selectedValue == 2 ) {
					setVisible(false);
					GameManager d = new GameManager(menu, level+1, mode);
					menu.show(d);
				}

			}
		}

		public boolean placePiece(Shape shape) {
			int boxCount = col.getCount(dummy);
			int  xs[] = new int[boxCount];
			int  ys[] = new int[boxCount];
			trueBoxes = new Box[boxCount];

			for(int i = 0; i <boxCount; i++)
			{
				xs[i] = shape.getBoxes()[i].x;
				ys[i] = shape.getBoxes()[i].y;

			}

			trueBoxes = grid.makeOccupied(xs, ys,boxCount);
			if(grid.getTrueCount() == boxCount)
				return true;

			return false;

		}
	}
	public class backListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			levelPanel l = new levelPanel(menu);
			
			menu.show(l);
			if(mode == 3)
				time3.stop();
			

			if(mode == 0)
				time0.stop();
			
			if(mode == 1) {
				time2.stop();
				time.stop();
			}

		}	

	}
	
	public class solListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(!showSol) {
				solution.setVisible(true);
				showSol = true;
			}
			
			else {
				solution.setVisible(false);
				showSol = false;
			}
			
		}	

	}

	public class finListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(turn % 4 == 0  || turn %4 == 2)
				turn += 2;
			else
				turn += 1;

			player1 = !player1;
			repaint();
		}	

	}


	public class time0Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String text = time0Label.getText();
			int i = Integer.parseInt(text);

			i++;

			time0Label.setText(i+"");

		}	
	}


	public class timeListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String text = timeLabel.getText();
			int i = Integer.parseInt(text);
			if(i > 0) {
				i--;
				timeLabel.setText(i+"");
			}
			else {
				time.stop();
				time2.stop();
				Object[] options = {"Retry Level",
						"Level Select",
				};


				int selectedValue = JOptionPane.showOptionDialog(null,
						"PLAYER 2 HAS WON",
						"PLAYER 2 HAS WON",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[1]);



				if(selectedValue == 0 ) {
					setVisible(false);
					GameManager d = new GameManager(menu, level , mode );
					menu.show(d);
				}
				if(selectedValue == 1 ) {
					setVisible(false);
					levelPanel d = new levelPanel(menu);
					menu.show(d);

				}

			}
		}	
	}


	public class time2Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String text = time2Label.getText();
			int i = Integer.parseInt(text);
			if(i > 0) {
				i--;
				time2Label.setText(i+"");
			}

			else {
				time.stop();
				time2.stop();
				Object[] options = {"Retry Level",
						"Level Select",
				};


				int selectedValue = JOptionPane.showOptionDialog(null,
						"PLAYER 1 HAS WON",
						"PLAYER 1 HAS WON",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[1]);

				if(selectedValue == 0 ) {
					setVisible(false);
					GameManager d = new GameManager(menu, level , mode );
					menu.show(d);
				}
				if(selectedValue == 1 ) {
					setVisible(false);
					levelPanel d = new levelPanel(menu);
					menu.show(d);

				}
			}
		}
	}

	public class time3Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String text = time3Label.getText();
			int i = Integer.parseInt(text);
			if(i > 0) {
				i--;
				time3Label.setText(i+"");
			}

			else if (i == 0){
				time3.stop();
				int selectedValue = 0;

				Object[] options = {"Retry",
				"Level Select"};

				selectedValue = JOptionPane.showOptionDialog(null,
						"YOU LOST!! TRY AGAIN!!",
						"LEVEL FAILED!!",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[1]);

				if(selectedValue == 0 ) {
					setVisible(false);
					GameManager d = new GameManager(menu, level , mode );
					menu.show(d);
				}
				if(selectedValue == 1 ) {
					setVisible(false);
					levelPanel d = new levelPanel(menu);
					menu.show(d);

				}

	
				int totTime = Integer.parseInt(totalTime2);
				totTime = totTime + ((7*level));
				totalTime2 = String.valueOf(totTime);

				int totMove = Integer.parseInt(totalMove2);
				totMove = totMove + moveCount[level];
				totalMove2 = String.valueOf(totMove);

				int totPlay = Integer.parseInt(totalPlay2);	
				totPlay++;
				totalPlay2 = String.valueOf(totPlay);


				fm.deleteBombAll();


				fm.writeBombFile(totalTime2);
				fm.writeBombFile(totalMove2);
				fm.writeBombFile(totalPlay2);

			}

		}

	}
}
