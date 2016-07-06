package Chapter_04_Mathematical_Functions_Characters_And_Strings;
import java.util.Scanner;

/**
 * Find the character of an ASCII code
 * Write a program that receives an ASCII code (an integer between 0 and 127) and displays its character.
 * 
 *  02/11/2016
 * @author kevgu
 *
 */

public class Programming_Exercise_08 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer between 0 and 127: ");
		int number = input.nextInt();
		
		char ascii = (char) number;
		
		System.out.print("The ASCII of " + number + " is " + ascii);
		input.close();
	}
}
