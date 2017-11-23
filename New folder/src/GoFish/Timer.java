package GoFish;

public class Timer {
	private static long time1; //start
	private static long time2; //end
	private static long time3; //difference in nanoseconds
	private static double time4; //difference in milliseconds
	private static int timed=0; //turn timer on or off
	
	public static void Start()
	{
		time1 = System.nanoTime();
	}
	public static void End()
	
	{
		time2 = System.nanoTime();
		time3 = (time2 - time1);
		time4 = (time3/1000000.0);
		if(timed==1)
		{
			System.out.println("Time passed: " + time3 + " nanoseconds or " + time4 + " milliseconds or " + (time3/1000000000.0) + " seconds.");
			Driver.addTime(time4); //adds the new time in milliseconds to the time table in database
		}
	}
}
