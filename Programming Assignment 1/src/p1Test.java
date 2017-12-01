/**
	Sample program to test the basic functionality of the GameCharacter class hierarchy
	
	If your classes work correctly, part of the output should show:
	 Legolas attacked Boromir successfully.
	 Boromir attacked Saruman unsuccessfully.
	 Saruman attacked Legolas successfully.
	 
	AFTER ONE BATTLE, the output should show that 
	Legolas is left with 70 pts at position (15,30),
	Boromir is left with 90 pts at position (23,30), and
	Saruman is left with 100 pts at position (30,40)
*/

public class p1Test
{
	static final int MAX = 10;  
	
	public static void main(String [] args)
	{
		int numCharacters = 3;
		
		GameCharacter[] chars = new GameCharacter[MAX];
		chars[0] = new Archer("Legolas", 20, 30);
		chars[1] = new Knight("Boromir", 25, 30);
		chars[2] = new Wizard("Saruman", 50, 40);
		displayGame("IN THE BEGINNING ...", chars, numCharacters);
		for (int i = 0; i < numCharacters; i++)
		{
			chars[i].move('W', 20);
			int target = (i + 1) % numCharacters;
			boolean success = chars[i].attack(chars[target]);
			describeAttack(chars[i], chars[target], success);
		}
		displayGame("AFTER ONE BATTLE ...",chars, numCharacters);
	}

/**
	Displays all the characters in the array passed as argument.
	@param legend the legend to be displayed at the top of the output
	@param world  an array of GameCharacter objects to be displayed
	@param number the number of array elements to display
*/
	public static void displayGame(String legend, GameCharacter[] world, int number)
	{
		System.out.println("\n" + legend);
		for (int i = 0; i < number; ++i)
			System.out.println("\t" + world[i]);
	}
	
/**
	Displays a message describing the result of an attack.
	@param attacker the GameCharacter performing the attack
	@param target   the GameCharacter targeted by the attacker
	@param success  true if the attack was successful, false otherwise
*/	
	public static void describeAttack(GameCharacter attacker, GameCharacter target, boolean success)
	{
		String output = "\t "+  attacker.getName() + " attacked " + target.getName() + " ";
		if (!success)
			output += "un";
		output += "successfully.";
		System.out.println(output);
	}
}

