import java.util.List;
import java.util.ArrayList;

public class SpiralRearranger
{
	public Integer[] rearrangeInSpiralOrder( Integer[][] arr )
	{
		if( arr.length == 0 )
			return new Integer[ 0 ];
		
		int colCount = arr[ 0 ].length;
		int rowCount = arr.length;

		SpiralOrderNavigator nav = new SpiralOrderNavigator( colCount , rowCount );

		List<Integer> spiraledMembers = new ArrayList<Integer>();

		while( nav.hasNext() )
		{
			SpiralMatrixCell cell = nav.getNext();

			System.out.println( cell );

			spiraledMembers.add( arr[ cell.getY() ][ cell.getX() ] );
		}

		return ( Integer[] ) spiraledMembers.toArray( new Integer[ spiraledMembers.size() ] );
	}
}