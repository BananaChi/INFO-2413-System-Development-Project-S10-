package GoFish;

public class Timer {
	private static long time1; //start
	private static long time2; //end
	private static long time3; //difference in nanoseconds
	
	private static int timed=1; //turn timer on or off
	
	public static void Start()
	{
		time1 = System.nanoTime();
	}
	
	public static void End()
	{
		time2 = System.nanoTime();
		time3 = (time2 - time1);
		
		if(timed==1)
		{
			System.out.println("Time passed: " + time3 + " nanoseconds or " + (time3/1000000.0) + " milliseconds or " + (time3/1000000000.0) + " seconds.");
		}
		
	}
	

}
