import java.util.*;

public class StatesGame
{
	static final ArrayList<String> STATES = new ArrayList<String>(Arrays.asList("Alabama", "Alaska", 
	"Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", 
	"Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", 
	"Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", 
	"Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", 
	"New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", 
	"Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", 
	"Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", 
	"Wisconsin", "Wyoming"));
	
	static ArrayList<String> compareStates = new ArrayList<String>();
	
	static ArrayList<String> answered = new ArrayList<String>();
	
	public static String hint()
	{	
		for(int i = 0; i <= STATES.size() - 1; i++)
		{ 
			if(STATES.get(i) != compareStates.get(i))
			{
				String retVal = STATES.get(i).toUpperCase().charAt(0);
				break;
			}
		}
	}
	
	public static void isAnswer(String input)
	{			
		if(compareStates.contains(input))
		{
			if(answered.contains(input))
			{
				System.out.println("You said that already!");
			}
			else
			{
				answered.add(input);
			}
		}
		else
		{
			System.out.println("That's not a state!");
		}
	}
	
	public static void main(String args[])
	{	
		// Initialize the comparing array to get around case sensitivity
		for(int i = 0; i <= STATES.size() - 1; i++)
		{
			compareStates.add(STATES.get(i).toLowerCase());
		}
		
		System.out.println("Welcome to the States Game! Lets see if you can name all 50 States! Type 'help' for a list of commands.");
		
		while(answered.size() <= 50)
		{
			String input = new Scanner(System.in).nextLine().toLowerCase();
			
			if(input.equals("hint"))
			{
				System.out.println("Here's a hint: " + hint());
			}
			else
			{
				isAnswer(input);
			}
		}
		
		System.out.println("Congrats! You named all 50 states :)!");
	}
}