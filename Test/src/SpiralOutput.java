public class SpiralOutput
{
	public static void main( String[] args )
	{
		SpiralRearranger spiralRearranger = new SpiralRearranger();

		Integer[][] nums = new Integer[][]
										{
											{1,2,3,4},
											{5,6,7,8},
											{9,10,11,12},
											{13,14,15,16}
										};

		Integer[] spiraledNums = spiralRearranger.rearrangeInSpiralOrder( nums );

		for( Integer num : spiraledNums )
		{
			System.out.println( num );
		}
	}
}