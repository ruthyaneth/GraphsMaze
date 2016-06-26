package drawMaze;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Board extends JPanel
{
	private int size;
	private Cell[][] grid;
	private boolean inputAllowed = true; //allows input until a button locks it
	private boolean wallOrPoint = true; //true for walls, false for (start/end)
	
	public Board(int size, Cell[][] grid)
	{
		this.size = size;
		this.grid = grid;
		setPreferredSize(new Dimension(size*(grid[0].length), size*(grid.length)));
	
		addMouseMotionListener
		(
			new MouseMotionAdapter()
			{
				public void mouseDragged(MouseEvent e)
				{
//					mouseAction(e);
				}
			}
		);
		
		addMouseListener
		(
			new MouseAdapter()
			{
				public void mousePressed(MouseEvent e)
				{
//					mouseAction(e);
				}
			}
		);
	}
	
	//when a mouse click or movement is detected, run this method
//	public void mouseAction(MouseEvent e)
//	{
//		if (inputAllowed)
//		{
//			if (SwingUtilities.isLeftMouseButton(e))
//			{
//				if (wallOrPoint)
//				{
//					grid[e.getY() / size][e.getX() / size].setState(1);
//				} else if (count()) 
//				{
//					grid[e.getY() / size][e.getX() / size].setState(2);
//				}
//			} else if (SwingUtilities.isRightMouseButton(e))
//			{
//				grid[e.getY() / size][e.getX() / size].setState(0);
//			}
//			repaint();
//		}	
//	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				int x = size*(j);
				int y = size*(i);
				g.setColor(Color.BLACK);
				g.drawRect(x, y, size, size);
				
				g.setColor(Color.WHITE);
				//do progress colors
				if (grid[i][j].getVisited() || grid[i][j].getOpen()) g.setColor(Color.LIGHT_GRAY);
				if (grid[i][j].getClose()) g.setColor(Color.CYAN);
				if (grid[i][j].getOnPath()) g.setColor(Color.RED);
				
				//do walls and points (they override progress colors)
				if (grid[i][j].getState() == 1) g.setColor(Color.BLACK);
				if (grid[i][j].getState() == 2) g.setColor(Color.GREEN);
				g.fillRect(x+1, y+1, size-1, size-1);
			}
		}
	}
	
	public void setInputAllowed(boolean b)
	{
		this.inputAllowed = b;
	}
	
	public boolean getInputAllowed()
	{
		return this.inputAllowed;
	}
	
	public void setWallOrPoint(boolean b)
	{
		this.wallOrPoint = b;
	}
	
	public boolean getWallOrPoint()
	{
		return wallOrPoint;
	}
	
	public boolean count()
	{
		int count = 0;
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				if (grid[i][j].getState() == 2) count++;
			}
		}
		if (count < 2) return true;
		else return false;
	}
}