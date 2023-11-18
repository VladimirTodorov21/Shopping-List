/*This program runs a code that prompts the user to input a string containing an item and its price separated by a dollar sign,
 *and then separated by a comma to introduce the next set of item and price. The program divides the string (input) into multiple strings
 *after they have been separated from the comma. Each individual string is then separated from the dollar sign to introduce the item
 *and price separately as strings. Next, the string price is parsed as to the type integer and is assigned to a 1-D array. Similarly, 
 *the string item is converted into a character array and a 2-D character array is declared containing that conversion. Using for loops,
 *the system assigns letters of the divided items and outputs them in order, and displays the total price at the end by taking into account
 *the price associated with those items.*/

package assignment3;

import java.util.*; //Scanner needs to be imported

public class assignment3code2 
{
	public static void main (String[] args)
	{
		/*Scanner declared as ShoppingList*/
		Scanner ShoppingList = new Scanner(System.in);
	
		/*Formated output for header of the welcome message*/
		System.out.println("-------****-------****-------****-------****-----");
		System.out.println("      Welcome to Shopping List Program!");
		System.out.println("-------****-------****-------****-------****-----\n");
		
		/*Prompts user to input their shopping list*/
		System.out.println("Please enter your shopping list (item$price and seperate by comma)");
		
		String AllItemsAndPrices = ShoppingList.next(); //input of the user
		String[] ItemsAndPrices = AllItemsAndPrices.split(","); //input is split into a 1-D string array from comma (,)
		
		/*Condition if the input from the user is 0, then display a message in which user has 0 items*/
		if (AllItemsAndPrices.equals("0"))
		{
			System.out.println("\nYou have 0 items in the list now!\n");
		} 
		else //otherwise, executes the following statements
		{
			System.out.println("\nHere is the list of items:\n"); //displays a message introducing the list of items
			int totalPrice = 0; //set total price of combined items to 0
			
			/*for loop: */
			for (int a = 0; a < ItemsAndPrices.length; a++)
			{
				String ItemAndPrice = ItemsAndPrices[a]; //position of the array "ItemsAndPrices" is declared as a string
				String[] SeperateItemAndPrice = ItemAndPrice.split("\\$"); //new array declared from the separation of 2 new strings by dollar sign "$"
				
				String item = SeperateItemAndPrice[0]; //string item comes before dollar sign "$"
				String price = SeperateItemAndPrice[1]; //string price comes after dollar sign "$"
				
				int[] Price = {Integer.parseInt(price)}; //1-D integer array "Price" is a 0x1 array in which its column is a string type "price" converted into an integer type
				
				char[][] cItem = {item.toCharArray()}; //2-D character array "cItem" is a 0x(length of string "item") 
				
				System.out.print("No." + (a+1) + " "); //displays the order of the item and the name of the item
				
				/*for loop: enters the row of 2-D char array "cItem" */
				for (int b = 0; b < cItem.length; b++)
				{
					/*for loop: enters the column of the specific of 2-D char array "cItem" */
					for (int c = 0; c < cItem[b].length; c++)
					{
						System.out.print(cItem[b][c]); //prints the characters from left to right inside a row
					}
					System.out.println(); //new line after the word inside a row has been output
				}
				
				/*for loop: enters the column of 1-D int array "Price" */
				for (int d = 0; d < Price.length; d++)
				{
					totalPrice += Price[d]; //integer totalPrice is added to the price of the item
				}
			}
			
			System.out.println("The total price is: $" + totalPrice + ".\n\n"); //displays total price of the combined items
		}
		
		System.out.println("Thank you for using this program!!"); //displays farewell message to user of this program
		
		ShoppingList.close(); //close Scanner
	} //end of main
} //end of public class
