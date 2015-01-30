public class SpiralOrderNavigator
{
	private static final int DIRECTION_RIGHT = 1;
	private static final int DIRECTION_DOWN = 2;
	private static final int DIRECTION_LEFT = 3;
	private static final int DIRECTION_UP = 4;

	private SpiralMatrixCell[][] cells;
	private int colCount , rowCount;
	private Integer currentX , currentY;
	private int unusedCount;
	private int currentDirection;

	public SpiralOrderNavigator( int colCount , int rowCount )
	{
		this.colCount = colCount;
		this.rowCount = rowCount;

		cells = new SpiralMatrixCell[ rowCount ][ colCount];

		for( int i = 0 ; i < rowCount ; i++ )
		{
			for( int j = 0 ; j < colCount ; j++ )
			{
				cells[ i ][ j ] = new SpiralMatrixCell( j , i );
			}
		}

		unusedCount = colCount * rowCount;

		currentX = null;
		currentY = null;
	}

	public boolean hasNext()
	{
		return unusedCount > 0;
	}

	public SpiralMatrixCell getNext()
	{
		SpiralMatrixCell cell2Return = null;

		if( currentX == null )
		{
			currentDirection = DIRECTION_RIGHT;

			cell2Return = cells[ 0 ][ 0 ];
		}
		else
		{
			SpiralMatrixCell cellInCurrentDirection = getCellInCurrentDirection();

			if( cellInCurrentDirection != null && !cellInCurrentDirection.isUsed() )
			{
				cell2Return = cellInCurrentDirection;
			}
			else if( cellInCurrentDirection == null || cellInCurrentDirection.isUsed() )
			{
				currentDirection = getDirectionToRight();

				cell2Return = getCellInCurrentDirection();
			}
		}

		currentX = cell2Return.getX();
		currentY = cell2Return.getY();

		unusedCount--;
		
		cell2Return.markAsUsed();

		return cell2Return;
	}

	private int getDirectionToRight()
	{
		switch( currentDirection )
		{
			case DIRECTION_RIGHT :
				return DIRECTION_DOWN ;
			case DIRECTION_DOWN :
				return DIRECTION_LEFT;
			case DIRECTION_LEFT :
				return DIRECTION_UP;
			case DIRECTION_UP :
				return DIRECTION_RIGHT;
		}

		return -1;
	}

	private SpiralMatrixCell getCellInCurrentDirection()
	{
		switch( currentDirection )
		{
			case DIRECTION_RIGHT :
				return getRightCell();
			case DIRECTION_DOWN :
				return getDownCell();
			case DIRECTION_LEFT :
				return getLeftCell();
			case DIRECTION_UP :
				return getUpCell();
		}

		return null;
	}

	public SpiralMatrixCell getUpCell()
	{
		if( currentY == 0 )
			return null;

		return cells[ currentY - 1 ][ currentX ];
	}

	public SpiralMatrixCell getDownCell()
	{
		if( currentY == rowCount - 1 )
			return null;

		return cells[ currentY + 1 ][ currentX ];
	}

	public SpiralMatrixCell getLeftCell()
	{
		if( currentX == 0 )
			return null;

		return cells[ currentY ][ currentX - 1 ];
	}

	public SpiralMatrixCell getRightCell()
	{
		if( currentX == colCount - 1 )
			return null;

		return cells[ currentY ][ currentX + 1  ];
	}
}