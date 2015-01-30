import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpiralFileExample
{
	public static void main( String[] args ) throws IOException
	{
		if( args.length == 0 )
		{
			System.out.println( "Please provide the name of the file containing the array" );
			return;
		}
		
		BufferedReader in = new BufferedReader( new FileReader( new File( args[ 0 ] ) ) );
		
		String line = null;
		
		List<Integer[]> completeArray = new ArrayList<Integer[]>();
		
		while( ( line = in.readLine() ) != null )
		{
			Integer[] arr = getArray( line );
			
			completeArray.add( arr );
		}
		
		Integer[][] finalArr = completeArray.toArray( new Integer[ completeArray.size() ][] );
		
		SpiralRearranger spiralRearranger = new SpiralRearranger();

		Integer[] spiraledNums = spiralRearranger.rearrangeInSpiralOrder( finalArr );

		for( Integer num : spiraledNums )
		{
			System.out.println( num );
		}
	}

	private static Integer[] getArray( String line )
	{
		String[] parts = line.split( "\t" );
		
		List<Integer> ints = new ArrayList<Integer>();
		
		for( String part : parts )
		{
			ints.add( Integer.decode( part ) );
		}
		
		return ( Integer[] ) ints.toArray( new Integer[ ints.size() ] );
	}
}