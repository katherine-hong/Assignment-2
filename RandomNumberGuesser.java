/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: This program uses the file RNG.java to create a program
 * that allows the user to guess a randomly generated number. 
 * Due: 09/28/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Katherine Hong
*/



import java.util.Scanner;


public class RandomNumberGuesser {

	public static void main(String[] args) {
		
		// The following creates a scanner object to get input
		Scanner input = new Scanner(System.in);
		
		// The following creates the necessary variables for the program
		int guess; // User's guess
		int answer; // The actual correct answer that is randomly generated
		int max = 100;
		int min = 0;
		int falseMax = 100;
		int falseMin = 0;
		boolean check;
		int countNum;
		String again;
		
		
		// The following randomly generates a number and assigns it to the answer variable
		answer = RNG.rand();
		
		// The following gets the count
		countNum = RNG.getCount();
		
		// The following prints out the purpose of the program
		System.out.println("This application generates a random integer between 1 and 100"
				+ "\n\tand asks the user to guess repeatedly until they guess correctly.\n");
		
		// The following resets the count
		//RNG.resetCount();
		
		// The following gets the count number
		//countNum = RNG.getCount();
		
		do
		{
			RNG.resetCount();
			countNum = RNG.getCount();
			countNum++;
			
			// The following asks the user to enter their first guess
			System.out.println("Enter your first guess");
			guess = input.nextInt();
			check = RNG.inputValidation(guess, min, max);
			
			if(guess > 100)
			{
				guess = 100;
			}
			else if(guess < 0)
			{
				guess = 0;
			}
			
			while(guess != answer && countNum <= 7)
			{
				if(guess == answer)
				{
					System.out.println("Congratulations, you guessed correctly");
				}
				else if(guess < answer)
				{
					System.out.println("Your guess is too low");
					
					if(guess < min || guess > max)
					{
						guess = falseMin;
					}
					else
					{
						min = guess;
					}
					
					//min = guess;
					System.out.println("Number of guesses is: " + countNum);
					System.out.println("Enter your next guess between " + min
							+ " and " + max);
					countNum++;
					guess = input.nextInt();
					check = RNG.inputValidation(guess, min, max);
					
				}
				else if(guess > answer)
				{
					System.out.println("Your guess is too high");
					
					if(guess < min || guess > max)
					{
						guess = falseMax;
					}
					else
					{
						max = guess;
					}
					
					max = guess;
					System.out.println("Number of guesses is: " + countNum);
					System.out.println("Enter your next guess between " + min
							+ " and " + max);
					countNum++;
					guess = input.nextInt();
					check = RNG.inputValidation(guess, min, max);
				}
			}
			
			if(guess == answer)
			{
				System.out.println("Congratulations, you guessed correctly");
			}
			else
			{
				System.out.println("You have exceeded the maximum number of guesses, 7."
						+ " Try again.");
			}
			
			input.nextLine(); // may not need
			
			System.out.println("Try again? (yes or no)");
			again = input.nextLine();
			guess = 0;
			min = 0;
			max = 100;
			
		} while(again.equals("yes") || again.equals("Yes") || again.equals("y"));
		
		System.out.println("Thanks for playing...");
		System.out.println("Programmer name: Katherine Hong");
		
		
		
	}

}
