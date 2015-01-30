public class SpiralMatrixCell
{
	private int x;
	private int y;
	private boolean used;

	public SpiralMatrixCell( int x , int y )
	{
		this.x = x;
		this.y = y;
		used = false;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public boolean isUsed()
	{
		return used;
	}
	
	public String toString()
	{
		return "[x = " + x + "][y = " + y + "][" + ( isUsed() ? "USED" : "UN-USED" ) + "]";
	}

	public void markAsUsed()
	{
		used = true;
	}
}