package drawMaze;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class MazeCreator
{
	public static int size = 15;
	public static int delay = 50;
	public static Cell[][] grid = new Cell[45][45];
	public static boolean solveTime = false;
	public static boolean completed = false;
	
	public static void main(String[] args) {
		
		//create the board
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[i].length; j++)
			{
				grid[i][j] = new Cell();
			}
		}
		Board board = new Board(size, grid);
		
		//create a label that will show messages
		JLabel notif = new JLabel(" Input: Wall Mode     ");
		
		//create the button to switch between wallñ..jtw	7h7q	qA<<<<<Es and points
		JButton wallOrPointButton = new JButton("Switch to Start/End");
		wallOrPointButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!solveTime)
				{
					board.setWallOrPoint(!board.getWallOrPoint());
					if (wallOrPointButton.getText().equals("Switch to Start/End")) 
					{
						notif.setText(" Input: Start/End Mode");
						wallOrPointButton.setText("  Switch to Walls  ");
					}
					else 
					{
						notif.setText(" Input: Wall Mode     ");
						wallOrPointButton.setText("Switch to Start/End");
					}
				}
			}
		});
		
		//create the button that locks down the input and solves the maze
		JButton solveButton = new JButton("   Solve   ");
		solveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!completed) solveTime = true;
				else if (!solveTime) //button is pressed while maze is already solved (Solve Again)
				{
					//clear the visited and onPath states of the board, begin solving again
					for (int i = 0; i < grid.length; i++)
					{
						for (int j = 0; j < grid[i].length; j++)
						{
							grid[i][j].setVisited(false);
							grid[i][j].setOnPath(false);
							grid[i][j].setOpen(false);
							grid[i][j].setClose(false);
						}
					}
					solveTime = true;
				}
			}
		});
		
		//create the button to clear the grid
		JButton clearButton = new JButton("Reset");
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!solveTime)
				{
					for (int i = 0; i < grid.length; i++)
					{
						for (int j = 0; j < grid[0].length; j++)
						{
							grid[i][j] = new Cell();
						}
					}
					board.repaint();
					completed = false;
					solveButton.setText("   Solve   ");
				}
			}
		});
		
		//create the button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(wallOrPointButton);
		buttonPanel.add(solveButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(notif);
		
		//create the JPanel that will contains the slider
		JPanel sliderPanel = new JPanel();
		JSlider slider = new JSlider(JSlider.VERTICAL, 5, 1000, 50);
		slider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				JSlider source = (JSlider) e.getSource();
				delay = (int) source.getValue();
			}
		});
		
		//create the frame
		JFrame frame = new JFrame("Maze Creator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(board, BorderLayout.CENTER);
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		frame.getContentPane().add(slider, BorderLayout.EAST);
		frame.validate();
		frame.pack();
		frame.setVisible(true);
		
		while (true)
		{
			if (solveTime)
			{
				notif.setText(" Solving...           ");
				board.setInputAllowed(false);
				solve(board, notif);
				board.setInputAllowed(true);
				solveTime = false;
				
				//set completed to true to update logic, change the button text
				solveButton.setText("Solve Again");
				completed = true;
			}
		}
		
	}
	
	//solves the maze, showcasing the process using repaint along the way
	public static void solve(Board board, JLabel notif)
	{
		//              W  S  E  N
		int[] dX =    {-1, 0, 1, 0};
		int[] dY =    { 0, 1, 0,-1};
		
		//determine the start and end coordinates
		int xS = -1, yS = -1, xE = -1, yE = -1;
		for (int i = grid.length-1; i >= 0; i--)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				if (grid[i][j].getState() == 2)
				{
					if (xS == -1)
					{
						xS = j;
						yS = i;
					} else
					{
						xE = j;
						yE = i;
					}
				}
			}
		}
		
		//can't find a start and end point set!
		if (xS == -1 || xE == -1) 
		{
			notif.setText(" Start/End not found. ");
			return;
		}
		
		//store parent directions
		int[][] pDir = new int[grid.length][grid[0].length];
		pDir[yS][xS] = -1; //stopping points
		
		//create weights
		int[][] w1 = new int[grid.length][grid[0].length]; //distance from start
		int[][] w2 = new int[grid.length][grid[0].length]; //straight distance to end
		w1[yS][xS] = 0;
		w2[yS][xS] =  (int) Math.abs(xE - xS) + (int) Math.abs(yE - yS);
		
		//create the lists
		ArrayList<Point> open = new ArrayList<Point>();
		ArrayList<Point> close = new ArrayList<Point>();
		open.add(new Point(xS, yS));
		grid[yS][xS].setOpen(true);
		board.repaint();
		
		/* Structure
			1. Choose node from open list with lowest f score
			2. Drop it from open list, add it to closed list
			3. Check its neighbors, add them to the open list
		*/
		
		while (true)
		{
			//check for empty list
			if (open.size() == 0)
			{
				notif.setText(" Failed to solve.     ");
				return;
			}
			
			//find the lowest f score
			int index = 0;
			int med = w1[open.get(0).getY()][open.get(0).getX()] + w2[open.get(0).getY()][open.get(0).getX()];
			for (int i = 0; i < open.size(); i++)
			{
				int test = w1[open.get(i).getY()][open.get(i).getX()] + w2[open.get(i).getY()][open.get(i).getX()];
				if (test <= med)
				{
					med = test;
					index = i;
				}
			}
			
			//move it to the closed list
			grid[open.get(index).getY()][open.get(index).getX()].setOpen(false);
			grid[open.get(index).getY()][open.get(index).getX()].setClose(true);
			close.add(open.remove(index));
			
			//check if the exit has been added
			if (close.get(close.size()-1).getX() == xE && close.get(close.size()-1).getY() == yE) break;
			
			//check neighbors, add them to the set
			for (int i = 0; i < 4; i++)
			{
				int x = close.get(close.size()-1).getX() + dX[i];
				int y = close.get(close.size()-1).getY() + dY[i];
				if (x >= 0 && x < grid[0].length && y >= 0 && y < grid.length && grid[y][x].getState() != 1 && !grid[y][x].getClose())
				{
					//scan the open list, add it if it's not there
					boolean c = true;
					for (int j = 0; j < open.size(); j++)
					{
						if (open.get(j).getY() == y && open.get(j).getX() == x)
						{
							c = false;
							break;
						}
					}
					if (c)
					{
						open.add(new Point(x, y));
						grid[y][x].setOpen(true);
						pDir[y][x] = (i + 2) % 4;
						w1[y][x] = w1[y-dY[i]][x-dX[i]] + 1;
						w2[y][x] = (int) Math.abs(xE - x) + (int) Math.abs(yE - y);
					} else
					{
						if (w1[y-dY[i]][x-dX[i]] + 1 < w1[y][x])
						{
							pDir[y][x] = (i + 2) % 4;
							w1[y][x] = w1[y-dY[i]][x-dX[i]] + 1;
						}
					}
				}
			}
			board.repaint();
			try{Thread.sleep(delay);} catch (InterruptedException e){e.printStackTrace();}
		}
		
		//backtrack from the end point and mark solutions
		int x = close.get(close.size()-1).getX();
		int y = close.get(close.size()-1).getY();
		while (x != xS || y != yS)
		{
			grid[y][x].setOnPath(true);
			int y1 = y;
			int x1 = x;
			y += dY[pDir[y1][x1]];
			x += dX[pDir[y1][x1]];
			board.repaint();
			try{Thread.sleep(delay);} catch (InterruptedException e){e.printStackTrace();}
		}
		notif.setText(" Solved!              ");
	}
}