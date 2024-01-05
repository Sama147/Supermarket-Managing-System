import java.util.Scanner;

public class supermarket_project 
{
	public static void main (String[] args)
	{
		boolean continueShopping = true;
		int total_sum = 0 ;
		int reciept = 0;
		int  final_reciept = 0;
    	 
    	while (continueShopping) 
    	{
    		// first, declaring arrays and intializing them
    		String[] Bakery = {"wheat -bread","tortillas","croissants","baguette"};
    		String[] Meat_Seafood = {"chicken","turkey","Salmon","mackerel"};
    		String[] Grains = {"Rice","Pasta","Oats","Whole-grain cereal"};
    		String[] Condiments = {"Ketchup","Mustard","Mayonnaise","Salad dressings"};
    		String[] Dairy = {"Milk","Cheese ","Yogurt","Eggs"};
    		String[] Fats = {"Olive oil","Vegetable oil","Butter"};
    		String[] fruits_vegetables = {"apples","bananas","oranges","lettuce","tomatoes","carrots","basil","cilantro","parsley","Potatoes","bell pepers"};		
    		String[] Snacks = {"Chips","Cookies","Soda","water"};
    		String[] cleaning_supplies = {"dish soap","Laundry detergent","broom","glass polish"};
    		String[] personal_care = {"shampoo","toothpaste","toilet paper","paper towels"}; 
    		
    		int[] Bakery_prices = {20,55,35,40};
    		int[] Meat_Seafood_prices = {65,70,100,70};
    		int[] Grains_prices = {30,40,120,30};
    		int[] Condiments_prices = {30,35,30,40};
    		int[] Dairy_prices = {20,20,25,65};
    		int[] Fats_prices = {18,18,20};
    		int[] fruits_vegetables_prices = {25,20,30,15,30,15,40,30,20,35,35};		
    		int[] Snacks_prices = {10,20,10,10};
    		int[] cleaning_supplies_prices = {30,35,25,15};
    		int[] personal_care_prices = {45,30,30,40};
    		
    		// Calling methods 
    		System.out.println("=============Welcome to our supermarket=============");
    		 printCategories();
    		 
    		 Scanner sc = new Scanner (System.in);
    		 System.out.println("Enter the number of the category you whant to explore");
    		 int choice= sc.nextInt();
    		  
    		 if (choice == 0)
    			continueShopping = false; 
    		 
    		 else if (choice >= 1 && choice <= 10) 
    		 {
    			 switch (choice)
        		 {
        		 	case 1:
        		 		menu_Bakery();
        		 		reciept = sum(Bakery, Bakery_prices, total_sum);
        		 		break;
        	
        		 	case 2:
        		 		menu_Meat_Seafood();
        		 		reciept = sum(Meat_Seafood, Meat_Seafood_prices, total_sum);
        		 		break;
        		 		
        		 	case 3:	
        		 		menu_Grains();
        		 		reciept = sum(Grains, Grains_prices, total_sum);
        		 		break;
        		 		
        		 	case 4:
        		 		menu_Condiments();
        		 		reciept = sum(Condiments, Condiments_prices, total_sum);
        		 		break;
        		 		
        		 	case 5:
        		 		menu_Dairy();
        		 		reciept = sum(Dairy, Dairy_prices, total_sum);
        		 		break;
        		 		
        		 	case 6:
        		 		menu_Fats();
        		 		reciept = sum(Fats, Fats_prices, total_sum);
        		 		break;
        		 		
        		 	case 7:
        		 		menu_fruits_vegetables();
        		 		reciept = sum(fruits_vegetables, fruits_vegetables_prices, total_sum);
        		 		break;
        		 		
        		 	case 8:
        		 		menu_Snacks();
        		 		reciept = sum(Snacks, Snacks_prices, total_sum);
        		 		break;
        		 		
        		 	case 9:
        		 		menu_cleaning_supplies();
        		 		reciept = sum(cleaning_supplies, cleaning_supplies_prices, total_sum);
        		 		break;
        		 		
        		 	case 10:
        		 		menu_personal_care();
        		 		reciept = sum(personal_care, personal_care_prices, total_sum);
        		 		break;
        		 }
    			 final_reciept += reciept;
    		 }
    		 
    	     else 
    	     {
    	    	 System.out.println("Invalid choice. Please enter a value between 1 and 10");
    	     }
    	 }
    	
    	 System.out.println("This is the final total : " + final_reciept + " egp");
    	 System.out.println("thanks for shopping at our Supermarket :)");
	}
	
	public static void printCategories() 
	{
		System.out.println("1.Bakery products --> 1");
		System.out.println("2.Meat and Seafood --> 2");
		System.out.println("3.Grains products --> 3");
		System.out.println("4.Condiments products --> 4");
		System.out.println("5.Dairy products--> 5");
		System.out.println("6.Fats products --> 6");
		System.out.println("7.fruits and vegetables --> 7");
		System.out.println("8.Snacks --> 8");
		System.out.println("9.cleaning supplies --> 9");
		System.out.println("10.personal care products --> 10");
	}
	
	public static void Bakery_choice() 
	{
		
		System.out.println("=========================================");
		  System.out.println("Wheat bread: 99.68 EGP per loaf "
				+ "\n" + "Tortillas: 116.02 EGP per pack"
				+ "\n" + "Croissants: 66.16 EGP each"
				+ "\n" + "Baguette: 82.65 EGP each");

	}
		
		public static int sum(String[] array_1, int[] array_2, int total)
		{
			Scanner scanner = new Scanner(System.in);
			int item, number_of_items, section_sum = 0;
			System.out.println("Enter the number of items you want to purchase");
			number_of_items = scanner.nextInt();
			
			System.out.println("Enter the respective numbers of the items you want to purchase");	
			for (int z = 0 ; z < number_of_items ; z++)
			{
				item = scanner.nextInt();
				section_sum += array_2[item - 1];
			}
			total += section_sum;
			System.out.println("Your total till now is : " + section_sum + " egp");
			return total;
			
		}
		
		public static void menu_Bakery()
		{
			System.out.println("=========================================");
	 		System.out.println("Wheat bread: 99.68 EGP per loaf --> 1 "
	 						+ "\n" + "Tortillas: 116.02 EGP per pack --> 2"
	 						+ "\n" + "Croissants: 66.16 EGP each --> 3"
	 						+ "\n" + "Baguette: 82.65 EGP each --> 4");
		}
		
		public static void menu_Meat_Seafood()
		{
			System.out.println("=========================================");
  		  	System.out.println("Chicken: 165.07 EGP per pound --> 1"
    				+ "\n" + "Turkey: 99.07 EGP per pound --> 2"
    				+ "\n" + "Salmon: 329.84 EGP per pound --> 3"
    				+ "\n" + "Mackerel: 230.34 EGP per pound --> 4");
  		  	System.out.println("=========================================");
		}
		
		public static void menu_Grains()
		{
			System.out.println("=========================================");
  		  System.out.println("Rice: 99.68 EGP per pound --> 1"
    				+ "\n" + "Pasta: 66.16 EGP per pack --> 2"
    				+ "\n" + "Oats: 132.32 EGP per container --> 3"
    				+ "\n" + "Whole-grain cereal: 148.81 EGP per box --> 4");
  		  System.out.println("=========================================");
		}
		
		public static void menu_Condiments()
		{
			System.out.println("=========================================");
  		  System.out.println("Ketchup: 82.65 EGP per bottle --> 1"
    				+ "\n" + "Mustard: 66.16 EGP per bottle --> 2"
    				+ "\n" + "Mayonnaise: 115.82 EGP per jar --> 3"
    				+ "\n" + "Salad dressings: 132.32 EGP per bottle --> 4");
  		  System.out.println("=========================================");
		}
		
		public static void menu_Dairy()
		{
			 System.out.println("========================================="); 
   		  System.out.println("Milk: 115.82 EGP per gallon --> 1"
       						+ "\n" + "Cheese: 165.07 EGP per block --> 2"
       						+ "\n" + "Yogurt: 66.16 EGP per container --> 3"
       						+ "\n" + "Eggs: 99.07 EGP per dozen --> 4");
		}
		
		public static void menu_Fats()
		{
			System.out.println("=========================================");
  		  	System.out.println("Olive oil: 231.64 EGP per bottle --> 1"
      						+ "\n" + "Vegetable oil: 99.07 EGP per bottle --> 2"
      						+ "\n" + "Butter: 132.32 EGP per pound --> 3");
		}
		
		public static void menu_fruits_vegetables()
		{
			System.out.println("=========================================");
  		  System.out.println("Apples: 66.16 EGP per kg --> 1"
      				+ "\n" + "Bananas: 22.70 EGP per kg --> 2"
      				+ "\n" + "Oranges: 49.48 EGP per kg --> 3"
      				+ "\n" + "Lettuce: 66.16 EGP per head --> 4"
      				+ "\n" + "Tomatoes: 82.65 EGP per kg --> 5"
      				+ "\n" + "Carrots: 49.48 EGP per kg --> 6"
      				+ "\n" + "Basil: 66.16 EGP per bunch --> 7"
      				+ "\n" + "Cilantro: 33.08 EGP per bunch --> 8"
      				+ "\n" + "Parsley: 49.48 EGP per bunch --> 9"
      				+ "\n" + "Potatoes: 99.07 EGP per kg --> 10"
      				+ "\n" + "Bell peppers: 66.16 EGP per kg --> 11");
  		  System.out.println("=========================================");
		}
		
		public static void menu_Snacks()
		{
  		  System.out.println("=========================================");
  		  System.out.println("Chips: 116.02 EGP per bag --> 1"
      						+ "\n" + "Cookies: 99.07 EGP per pack --> 2"
      						+ "\n" + "Soda: 66.16 EGP per bottle/can --> 3"
      						+ "\n" + "Water: 49.48 EGP per bottle --> 4");
  		  System.out.println("=========================================");
		}
		
		public static void menu_cleaning_supplies()
		{
			System.out.println("=========================================");
  		  System.out.println("Dish soap: 99.07 EGP per bottle --> 1"
      						+ "\n" + "Laundry detergent: 231.64 EGP per bottle --> 2");
  		  System.out.println("=========================================");
		}
		
		public static void menu_personal_care()
		{
			System.out.println("=========================================");
  		  	System.out.println("Shampoo: 165.07 EGP per bottle --> 1"
  		  						+ "\n" + "Toothpaste: 82.65 EGP per tube --> 2"
  		  						+ "\n" + "Toilet paper: 231.64 EGP per pack --> 3"
  		  						+ "\n" + "Paper towels: 132.32 EGP per roll --> 4");
  		  System.out.println("=========================================");
		}		
}
