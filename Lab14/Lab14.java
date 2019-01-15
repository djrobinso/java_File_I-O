import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;


/**********************************************************
  * Lab14.java -  Working with file inputs and outputs                                                                                                            *
  * Name: Deyonta Robinson 
  * Lab: Lab 14    
  * Course: CSCI 140/ CSCI 140L
  * Date: 4/18/2013                  
  **********************************************************/



public class Lab14 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.Variables
		Scanner keyboard = new Scanner(System.in);
		String word = "";
		String line = "";
		double totalValue = 0;
		double average = 0;
		int NumberofItems = 0;
		double price = 0;
		DecimalFormat df = new DecimalFormat("#.##");
		
		//2.Open the inventory file
		File inputFile = new File("inventory.txt");
		try {
			Scanner in = new Scanner(inputFile);
			
			while(in.hasNext())
			{
			price = in.nextDouble();
			totalValue = totalValue + price;
			NumberofItems++;
			}
			
			average = (totalValue/NumberofItems); //Find the average
			
			System.out.println("File Processed: " + inputFile);
			
			System.out.print("The total value of " + NumberofItems + " items is: $");
			System.out.print(df.format(totalValue));
			System.out.println();
			
			System.out.print("The average price has been determined to be: $");
			System.out.print(df.format(average));
			System.out.println();
			
			String message = "The total value of " + NumberofItems + " items is: $" + df.format(totalValue);
			message += "\n The average price has been determined to be: $" + df.format(average);
			
			PrintWriter out = new PrintWriter("processedInventory.txt");//Write this information to a file
			out.println(message);
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}

}
