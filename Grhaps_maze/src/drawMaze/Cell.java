package drawMaze;
public class Cell
{
	private int state; //0 if blank, 1 if wall, 2 if start/end
	private boolean onPath;
	private boolean open;
	private boolean close;
	private boolean visited;
	
	public Cell()
	{
		this.state = 0;
		this.visited = false;
		this.onPath = false;
		this.open = false;
		this.close = false;
	}
	public int getState()
	{
		return this.state;
	}
	
	public void setState(int x)
	{
		this.state = x;
	}
	
	public boolean getVisited()
	{
		return this.visited;
	}
	
	public void setVisited(boolean b)
	{
		this.visited = b;
	}
	
	public boolean getOnPath()
	{
		return this.onPath;
	}
	
	public void setOnPath(boolean b)
	{
		this.onPath = b;
	}
	
	public boolean getClose() { return this.close; }
	public void setClose(boolean b) { this.close = b; }
	
	public boolean getOpen() { return this.open; }
	public void setOpen(boolean b) { this.open = b; }
}