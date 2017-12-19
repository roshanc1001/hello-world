import java.util.Random;
import java.util.Scanner;

public class Chopsticks {
	static int numSticks = 21;
	static String playerName;
	public static void main(String[] args) {
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("INSTRUCTIONS");
		System.out.println("1. There are 21 Chopsticks in a stack.");
		System.out.println("2. In each turn, You and the Computer respectively can pick either one of two chopsticks.");
		System.out.println("3. The player who picks up the last chopstick loses.");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the name of your player:");
		playerName = input.nextLine();
		
		Random rand = new Random();
		
		int firstTurn = rand.nextInt(2);
		if (firstTurn==0) {
			System.out.println(playerName + " goes first!");
			game(firstTurn);
		}
		else {
			System.out.println("Computer goes first");
			game(firstTurn);
		}
	}
	
	public static void game(int counter) {
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		int sticksPicked;
		
		while(numSticks>2) {
			for(; (counter%2)==0; counter++) {
				System.out.println("Enter the number of chopsticks you would like to pick :");
				sticksPicked = input.nextInt();
				System.out.println( playerName + " picked " + sticksPicked + " chopsticks.");
				numSticks = numSticks - sticksPicked;
			}
			
			if (numSticks>2) {
				for( ; (counter%2)==1; counter++) {
					sticksPicked = rand.nextInt(2) + 1;
					System.out.println("The Computer picked " + sticksPicked + " chopsticks.");
					numSticks = numSticks - sticksPicked;
				}
			}
			System.out.println("There are " + numSticks + " chopsticks left in the stack." );
		}
		
		if (numSticks==2) {
			if((counter%2)==1) {
				System.out.println("The Computer picked the second-last chopstick.");
				System.out.println(playerName + " had to pick the last chopstick.");
				System.out.println(playerName + " Lost!");
			}
			else {
				System.out.println(playerName + " picked the second-last chopstick.");
				System.out.println("The Computer had to pick the last chopstick.");
				System.out.println(playerName + " Won!");
			}
		}
		else {
			if((counter%2)==1) {
				System.out.println("The Computer had to pick the last chopstick.");
				System.out.println(playerName + " Won!");
			}
			else {
				System.out.println(playerName + " had to pick the last chopstick.");
				System.out.println(playerName + " Lost!");
			}
		}
		
		System.out.println("Thanks for Playing!");
		System.out.println("-----------------------------------------------------------------------------------------");
	}
}
